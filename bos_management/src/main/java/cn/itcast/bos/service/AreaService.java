package cn.itcast.bos.service;

import cn.itcast.bos.javabean.Area;
import cn.itcast.bos.utils.Page;

import java.util.List;

/**
 * Created by xuhongnan on 2017/12/27.
 */
public interface AreaService {
    void batchImport(List<Area> areas);

    Page<Area> areaPageQuery(Integer page, Integer rows, Area area);
}
