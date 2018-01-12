package cn.itcast.bos.dao;

import cn.itcast.bos.javabean.Area;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xuhongnan on 2017/12/27.
 */
@Repository
public interface AreaMapper {

    void saveBatchImport(List<Area> areas);

    List<Area> findList(@Param("start") int start, @Param("rows") Integer rows, @Param("area") Area area);

    int findCount(@Param("area") Area area);
}
