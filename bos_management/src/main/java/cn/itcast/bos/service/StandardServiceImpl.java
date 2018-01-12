package cn.itcast.bos.service;

import cn.itcast.bos.dao.StandardMapper;
import cn.itcast.bos.javabean.Standard;
import cn.itcast.bos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuhongnan on 2017/10/17.
 */
@Service
public class StandardServiceImpl implements StandardService {
    @Autowired
    private StandardMapper standardMapper;
    @Override
    public void save(Standard standard) {
        Standard byId = standardMapper.findById(standard.getId());
        if(byId==null) {

            standardMapper.saveStandard(standard);
        }else {
            standardMapper.updateStandard(standard);
        }
    }

    @Override
    public Page<Standard> findStandard(Integer page, Integer rows) {
        int start=(page-1)*rows;
        List<Standard> list = standardMapper.findList(start, rows);
        Page<Standard> pages = new Page<>();
        pages.setRows(list);
        int total=standardMapper.findCount();
        pages.setTotal(total);


        return pages;
    }

    @Override
    public List<Standard> findAll() {
        return standardMapper.findAll();
    }
}
