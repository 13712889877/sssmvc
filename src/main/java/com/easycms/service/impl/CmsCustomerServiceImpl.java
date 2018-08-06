package com.easycms.service.impl;

import com.easycms.base.AbstractBaseDao;
import com.easycms.entity.CmsCustomer;
import com.easycms.entity.CmsUser;
import com.easycms.service.CmsCustomerService;
import com.easycms.service.CmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IYFT on 2018/8/3.
 */


@Service
public class CmsCustomerServiceImpl extends AbstractBaseDao<CmsCustomer, Integer> implements CmsCustomerService {

   @Autowired
   private CmsUserService cus;

    @Override
    public CmsCustomer findByName(String customerName) {
        String operate = ".findByName";
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("customerName", customerName);
        return findByParam(maps, operate);
    }


    @Override
    public void saveCustomer(CmsCustomer customer, CmsUser user) {
        save(customer);
        user.setId(customer.getCode());
        cus.save(user);
    }

    @Override
    public void deleteById(Integer customerId, Integer id) {
        //先删除关联外键的User表中的数据
        cus.delete(customerId);
        //然后再删除Customer表中的数据
        delete(id);
    }
}
