package cn.itcast.bos.dao;

import cn.itcast.bos.javabean.FixedArea;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xuhongnan on 2017/12/28.
 */
@Repository
public interface FixedAreaMapper {

    void saveFixedArea(FixedArea fixedArea);

    List<FixedArea> findList(@Param("start") int start, @Param("rows") Integer rows, @Param("fixedArea") FixedArea fixedArea);

    int findCount(@Param("fixedArea") FixedArea fixedArea);
}
