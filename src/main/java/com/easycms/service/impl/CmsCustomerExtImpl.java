package com.easycms.service.impl;

import com.easycms.base.AbstractBaseDao;
import com.easycms.common.Pager;
import com.easycms.entity.CmsCustomerExt;
import com.easycms.service.CmsCustomerExtService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IYFT on 2018/8/7.
 */
@Service
@Transactional
public class CmsCustomerExtImpl extends AbstractBaseDao<CmsCustomerExt, Integer> implements CmsCustomerExtService {
    @Override
    public Pager<CmsCustomerExt> salesSelect(int showPages, int pageSize, int ecUserId) {
        return null;
    }
}
