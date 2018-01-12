package cn.itcast.bos.controller;

import cn.itcast.bos.javabean.Standard;
import cn.itcast.bos.service.StandardService;
import cn.itcast.bos.utils.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuhongnan on 2017/10/17.
 */
@Controller
public class StandardController {
    @Autowired
    private StandardService standardService;

    @RequestMapping("standard_save.action")
/*添加收派标准*/
    public String standardSave(Standard standard) {
        standardService.save(standard);

        return "redirect:./pages/base/standard.html";
    }

    /*查询所有收派标准*/
    @ResponseBody
    @RequestMapping("standard_pageQuery.action")
    public Map findStandard(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30") Integer rows) throws JsonProcessingException {

        Page<Standard> pages = standardService.findStandard(page, rows);
        Map map = new HashMap<String, Object>();
        map.put("total", pages.getTotal());
        map.put("rows", pages.getRows());
        return map;
    }

    @ResponseBody
    @RequestMapping("standard_findAll")
    public List<Standard> findAll() {
        List<Standard> standards = standardService.findAll();
        return standards;
    }
}
