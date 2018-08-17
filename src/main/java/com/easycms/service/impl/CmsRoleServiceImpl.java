package com.easycms.service.impl;

import com.easycms.common.Pager;
import org.springframework.stereotype.Service;
import com.easycms.base.AbstractBaseDao;
import com.easycms.entity.CmsRole;
import com.easycms.service.CmsRoleService;

@Service
public class CmsRoleServiceImpl extends AbstractBaseDao<CmsRole, Integer> implements CmsRoleService {

    @Override
    public Pager<CmsRole> salesSelect(int showPages, int pageSize, int ecUserId) {
        return null;
    }
}
