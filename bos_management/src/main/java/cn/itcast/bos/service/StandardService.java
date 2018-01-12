package cn.itcast.bos.service;

import cn.itcast.bos.javabean.Standard;
import cn.itcast.bos.utils.Page;

import java.util.List;

/**
 * Created by xuhongnan on 2017/10/17.
 */
public interface StandardService {

     void save(Standard standard);
     Page<Standard> findStandard(Integer page, Integer rows);

     List<Standard> findAll();
}
