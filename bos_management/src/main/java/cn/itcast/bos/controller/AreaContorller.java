package cn.itcast.bos.controller;

import cn.itcast.bos.javabean.Area;
import cn.itcast.bos.service.AreaService;
import cn.itcast.bos.utils.Page;
import cn.itcast.bos.utils.PinYin4jUtils;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuhongnan on 2017/12/27.
 */
@Controller
public class AreaContorller {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "area_batchImport", method = RequestMethod.POST)
    public void batchImport(MultipartFile file) throws IOException {
        List<Area> areas = new ArrayList<Area>();

        CommonsMultipartFile cf= (CommonsMultipartFile)file;
        DiskFileItem fi = (DiskFileItem)cf.getFileItem();

        File f = fi.getStoreLocation();
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(f));

        HSSFSheet sheet = hssfWorkbook.getSheetAt(0);
        // 3、 读取sheet中每一行
        for (Row row : sheet) {
            // 一行数据 对应 一个区域对象
            if (row.getRowNum() == 0) {
                // 第一行 跳过
                continue;
            }
            // 跳过空行
            if (row.getCell(0) == null
                    || StringUtils.isBlank(row.getCell(0).getStringCellValue())) {
                continue;
            }
            Area area = new Area();
            area.setId(row.getCell(0).getStringCellValue());
            area.setProvince(row.getCell(1).getStringCellValue());
            area.setCity(row.getCell(2).getStringCellValue());
            area.setDistrict(row.getCell(3).getStringCellValue());
            area.setPostcode(row.getCell(4).getStringCellValue());
            // 基于pinyin4j生成城市编码和简码
            String province = area.getProvince();
            String city = area.getCity();
            String district = area.getDistrict();
            province = province.substring(0, province.length() - 1);
            city = city.substring(0, city.length() - 1);
            district = district.substring(0, district.length() - 1);
            // 简码
            String[] headArray = PinYin4jUtils.getHeadByString(province + city
                    + district);
            StringBuffer buffer = new StringBuffer();
            for (String headStr : headArray) {
                buffer.append(headStr);
            }
            String shortcode = buffer.toString();
            area.setShortcode(shortcode);
            // 城市编码
            String citycode = PinYin4jUtils.hanziToPinyin(city, "");
            area.setCitycode(citycode);

            areas.add(area);
        }
        areaService.batchImport(areas);

    }
    @ResponseBody
    @RequestMapping("area_pageQuery")
    public Map areaPageQuery(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30") Integer rows,Area area){
        Page<Area> pages=areaService.areaPageQuery(page,rows,area);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", pages.getTotal());
        map.put("rows", pages.getRows());
        return map;
    }
}
