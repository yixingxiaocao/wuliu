package cn.itcast.bos.dao;

import cn.itcast.bos.javabean.Courier;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xuhongnan on 2017/12/25.
 */
@Repository
public interface CourierMapper {
    void saveCourier(Courier c);

    List<Courier> findList(@Param("start") int start, @Param("rows") Integer rows,@Param("cour") Courier cour);

    int findCount(@Param("cour") Courier c);


    void deBatch(String ids);

    List<Courier> findnoassociation();
}
