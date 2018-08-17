package com.easycms.service.impl;

import com.easycms.common.Pager;
import com.easycms.entity.CmsCustomerExt;
import com.easycms.service.CmsCustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easycms.base.AbstractBaseDao;
import com.easycms.entity.CmsUserExt;
import com.easycms.service.CmsUserExtService;

@Service
@Transactional
public class CmsUserExtServiceImpl extends AbstractBaseDao<CmsUserExt, Integer> implements CmsUserExtService {

    @Override
    public Pager<CmsUserExt> salesSelect(int showPages, int pageSize, int ecUserId) {
        return null;
    }
}
