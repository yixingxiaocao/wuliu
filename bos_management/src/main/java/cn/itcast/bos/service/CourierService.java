package cn.itcast.bos.service;

import cn.itcast.bos.javabean.Courier;
import cn.itcast.bos.utils.Page;

import java.util.List;

/**
 * Created by xuhongnan on 2017/12/25.
 */
public interface CourierService {
    void saveCourier(Courier c);

    Page<Courier> findPageQuery(Integer page, Integer rows, Courier c);

    void delBatch(String[] idss);

    List<Courier> findnoassociation();
}
