package cn.itcast.bos.service;

import cn.itcast.bos.dao.AreaMapper;
import cn.itcast.bos.javabean.Area;
import cn.itcast.bos.javabean.Courier;
import cn.itcast.bos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuhongnan on 2017/12/27.
 */
@Service
public class AreaServiceImpl implements  AreaService{
    @Autowired
    private AreaMapper areaMapper;
    @Override
    public void batchImport(List<Area> areas) {
        areaMapper.saveBatchImport(areas);
    }

    @Override
    public Page<Area> areaPageQuery(Integer page, Integer rows, Area area) {
        int start=(page-1)*rows;
        List<Area> list=areaMapper.findList(start,rows,area);
        Page<Area> courierPage = new Page<>();
        courierPage.setRows(list);
        int total=areaMapper.findCount(area);
        courierPage.setTotal(total);
        return courierPage;
    }
}
