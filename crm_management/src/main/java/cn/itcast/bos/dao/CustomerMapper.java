package cn.itcast.bos.dao;

import cn.itcast.crm.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xuhongnan on 2018/1/3.
 */
@Repository
public interface CustomerMapper {
    List<Customer> findByFixedAreaIdIsNull();

    List<Customer> findByFixedAreaId(String fixedAreaId);

    void clearFixedAreaId(String fixedAreaId);

    void updateFixedAreaId(String fixedAreaId, Integer id);

    void regist(Customer customer);

    Customer findByTelephone(String telephone);

    void updateType(String telephone);
}
