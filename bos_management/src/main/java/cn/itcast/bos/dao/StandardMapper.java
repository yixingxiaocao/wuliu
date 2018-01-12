package cn.itcast.bos.dao;

import cn.itcast.bos.javabean.Standard;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xuhongnan on 2017/10/17.
 */
@Repository
public interface StandardMapper {
    void saveStandard(Standard standard);
    List<Standard> findStandard();

    List<Standard> findList(Integer page, Integer rows);

    int findCount();

    Standard findById(Integer id);

    void updateStandard(Standard standard);

    List<Standard> findAll();
}
