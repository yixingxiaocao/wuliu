package cn.itcast.bos.service;

import cn.itcast.bos.dao.CourierMapper;
import cn.itcast.bos.javabean.Courier;
import cn.itcast.bos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuhongnan on 2017/12/25.
 */
@Service
public class CourierServiceImpl implements CourierService {
    @Autowired
    private CourierMapper courierMapper;
    @Override
    public void saveCourier(Courier c) {
        courierMapper.saveCourier(c);
    }

    @Override
    public Page<Courier> findPageQuery(Integer page, Integer rows, Courier c) {
        int start=(page-1)*rows;
        List<Courier> list=courierMapper.findList(start,rows,c);
        Page<Courier> courierPage = new Page<>();
        courierPage.setRows(list);
        int total=courierMapper.findCount(c);
        courierPage.setTotal(total);
        return courierPage;
    }

    @Override
    public void delBatch(String[] idss) {
        for(String ids:idss){
            courierMapper.deBatch(ids);

        }
    }

    @Override
    public List<Courier> findnoassociation() {
        return courierMapper.findnoassociation();
    }
}
