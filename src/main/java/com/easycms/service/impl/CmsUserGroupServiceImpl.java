package com.easycms.service.impl;

import com.easycms.common.Pager;
import org.springframework.stereotype.Service;

import com.easycms.base.AbstractBaseDao;
import com.easycms.entity.CmsUserGroup;
import com.easycms.service.CmsUserGroupService;

@Service
public class CmsUserGroupServiceImpl extends AbstractBaseDao<CmsUserGroup, Integer> implements CmsUserGroupService {

    @Override
    public void updatePriority(Integer id, Integer priority) {
        CmsUserGroup cug = findById(id);
        cug.setPriority(priority);
        updateOrder(cug);
    }

    @Override
    public int findTotal() {
        Integer total=super.findTotal();
        return total;
    }

    @Override
    public Pager<CmsUserGroup> salesSelect(int showPages, int pageSize, int ecUserId) {
        return null;
    }
}
