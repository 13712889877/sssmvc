package com.easycms.service;

import com.easycms.base.BaseDao;
import com.easycms.entity.CmsCustomer;
import com.easycms.entity.CmsUser;

import java.util.List;

/**
 * Created by IYFT on 2018/8/3.
 */
public interface CmsCustomerService extends BaseDao<CmsCustomer, Integer> {

    /**
     * 根据用户名得到对应的对象
     *
     * @param customerName
     * @return
     */
    public CmsCustomer findByName(String customerName);

    /**
     * 保存用户信息的同时也要保存用户扩展信息
     *
     * @param customer
     * @param user
     */
    public void saveCustomer(CmsCustomer customer, CmsUser user);

    /**
     * 删除Customer数据的同时也要把User数据也删除
     *
     * @param customerId
     * @param id
     */
    public void deleteById(Integer customerId,Integer id);

    /**
     * 查询所有数据
     */
   public List findAll();


}

