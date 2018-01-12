package cn.itcast.bos.service;

import cn.itcast.bos.javabean.FixedArea;
import cn.itcast.bos.utils.Page;

/**
 * Created by xuhongnan on 2017/12/28.
 */
public interface FixedAreaService {
    void saveFixedArea(FixedArea fixedArea);

    Page<FixedArea> pageQuery(Integer page, Integer rows, FixedArea fixedArea);
}
