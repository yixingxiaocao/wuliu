package cn.itcast.bos.service;

import cn.itcast.bos.dao.CustomerMapper;
import cn.itcast.crm.domain.Customer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuhongnan on 2018/1/3.
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    // 注入DAO
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public List<Customer> findNoAssociationCustomers() {
        return customerMapper.findByFixedAreaIdIsNull();
    }

    @Override
    public List<Customer> findFixedAreaCustomers(String fixedAreaId) {
        return customerMapper.findByFixedAreaId(fixedAreaId);
    }

    @Override
    public void associationCustomersToFiexdArea(String customerIdStr, String fixedAreaId) {
        // 解除关联动作
        customerMapper.clearFixedAreaId(fixedAreaId);

        // 切割字符串 1,2,3
        if (StringUtils.isBlank(customerIdStr)) {
            return;
        }
        String[] customerIdArray = customerIdStr.split(",");
        for (String idStr : customerIdArray) {
            Integer id = Integer.parseInt(idStr);
            customerMapper.updateFixedAreaId(fixedAreaId, id);
        }
    }

    @Override
    public void regist(Customer customer) {
        customerMapper.regist(customer);
    }

    @Override
    public Customer findByTelephone(String telephone) {
        return customerMapper.findByTelephone(telephone);
    }

    @Override
    public void updateType(String telephone) {
        customerMapper.updateType(telephone);
    }
}

