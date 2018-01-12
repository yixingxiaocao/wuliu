package cn.itcast.bos.service;

import cn.itcast.bos.dao.FixedAreaMapper;
import cn.itcast.bos.javabean.Area;
import cn.itcast.bos.javabean.FixedArea;
import cn.itcast.bos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuhongnan on 2017/12/28.
 */
@Service
public class FixedAreaServiceImpl implements FixedAreaService{
    @Autowired
    private FixedAreaMapper fixedAreaMapper;
    @Override
    public void saveFixedArea(FixedArea fixedArea) {
        fixedAreaMapper.saveFixedArea(fixedArea);
    }

    @Override
    public Page<FixedArea> pageQuery(Integer page, Integer rows, FixedArea fixedArea) {
        int start=(page-1)*rows;
        List<FixedArea> list=fixedAreaMapper.findList(start,rows,fixedArea);
        Page<FixedArea> courierPage = new Page<>();
        courierPage.setRows(list);
        int total=fixedAreaMapper.findCount(fixedArea);
        courierPage.setTotal(total);
        return courierPage;
    }
}
