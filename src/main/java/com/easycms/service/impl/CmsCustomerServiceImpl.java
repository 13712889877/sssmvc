package com.easycms.service.impl;

import com.easycms.base.AbstractBaseDao;
import com.easycms.entity.CmsCustomer;
import com.easycms.entity.CmsCustomerExt;
import com.easycms.entity.CmsUser;
import com.easycms.service.CmsCustomerExtService;
import com.easycms.service.CmsCustomerService;
import com.easycms.service.CmsUserExtService;
import com.easycms.service.CmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IYFT on 2018/8/3.
 */


@Service
public class CmsCustomerServiceImpl extends AbstractBaseDao<CmsCustomer, Integer> implements CmsCustomerService {


    @Override
    public CmsCustomer findByName(String customerName) {
        String operate = ".findByName";
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("customerName", customerName);
        return findByParam(maps, operate);
    }


    @Override
    public void saveCustomer(CmsCustomer customer) {
        save(customer);

    }

    @Override
    public void deleteById(Integer customerId) {
        //先删除关联外键的User表中的数据
        delete(customerId);
        //然后再删除Customer表中的数据
        delete(customerId);
    }
@Override
    public List<CmsCustomer> findAllCustomer() {

        List<CmsCustomer> cmsList = super.findAll();

        return cmsList;
    }
@Override
    public void deleteIn(List<String> list) {
        super.deleteIn(list);
    }
@Override
     public void save(CmsCustomer customer){
        super.save(customer);
    }
}
