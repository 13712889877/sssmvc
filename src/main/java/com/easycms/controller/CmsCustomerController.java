package com.easycms.controller;

import com.easycms.common.Pager;
import com.easycms.constants.GlobalContants;
import com.easycms.entity.CmsCustomer;
import com.easycms.entity.CmsUser;
import com.easycms.service.CmsCustomerService;
import com.easycms.service.CmsLogService;
import com.easycms.service.CmsUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/customer")
public class CmsCustomerController {
    private static final Logger logger = Logger.getLogger(CmsCustomerController.class);
    public final static int PAGE_SIZE = 10;

    @Autowired
    private CmsCustomerService ccs;
    @Resource(name = "cmsUserServiceImpl")
    private CmsUserService us;
    @Resource(name = "cmsLogServiceImpl")
    private CmsLogService ls;

    /*主界面数据展示*/
    @RequestMapping("/list")
    public String findByPage(ModelMap model, Integer page) {
        //如果没有页码或者页码小于0，都置为查询第一页
        if (page == null || page <= 0) {
            page = 1;
        }
        //取当前页的记录
        Pager<CmsCustomer> customerPager = ccs.findByPage((page - 1) * PAGE_SIZE, PAGE_SIZE);
        //取总页数
        int total = ccs.findTotal();
        //组装上面查询的分页数据
        customerPager.setPage(page);
        customerPager.setTotal(total);
        customerPager.setTotalPage((total + (PAGE_SIZE- 1)) / 10);
        //查找所有销售数据
        List<CmsUser> userList = us.findAll();
        model.addAttribute("userList", userList);
        model.addAttribute("customerPager", customerPager);
        return "customer/customer-page-list";
    }

    /*单条数据删除*/
    @RequestMapping("/delete")
    public String delete(Integer customerId) {
        ccs.deleteById(customerId);
        return "redirect:/customer/list";
    }

    /*批量删除*/
    @RequestMapping("/deleteIn")
    public String deleteIn(HttpServletRequest req, ModelMap model) {
        //将前台传入的id已数组的形式存储
        String[] ids = req.getParameterValues("ids");
        //判断数组是否为空
        if (ids != null) {
            //创建一个集合
            List<String> list = new ArrayList<String>();
            //将id遍历出来放入集合中
            for (String id : ids) {
                list.add(id);
            }
            ccs.deleteIn(list);
            logger.info("delete CmsCustomer name={" + ids + "}");
        }
        return "redirect:/customer/list";
    }

    /*修改和删除准备阶段*/
    @RequestMapping("/beforeEdit")
    public String beforeEdit(ModelMap model, Integer id) {
        //判断id是否为空，为空则查找客户数据
        if (id == null) {
        } else {
            CmsCustomer customer = ccs.findById(id);
        }
        List<CmsUser> userList = us.findAll();
        model.addAttribute("userList", userList);
        return "customer/customer-edit";
    }

    /* 修改和新增方法*/
    @RequestMapping("edit")
    public String edit(CmsCustomer customer) {
        //判断客户主键，区分是更新还是插入
        if (customer.getCustomerId() == null) {

            ccs.saveCustomer(customer);
        } else {
            ccs.update(customer);
        }
        return "redirect:/customer/list";
    }

    @RequestMapping("salesSelect")
    public String salesSelect(Integer ecUserId,Integer page,ModelMap model) {
        //如果没有页码或者页码小于0，都置为查询第一页
        if (page == null || page <= 0) {
            page = 1;
        }
        //取当前页的记录
        Pager<CmsCustomer> customerPagers = ccs.salesSelect((page - 1) *PAGE_SIZE ,PAGE_SIZE,ecUserId);
        //取总页数
        int total = ccs.findTotal();
        //组装上面查询的分页数据
        customerPagers.setPage(page);
        customerPagers.setTotal(total);
        customerPagers.setTotalPage((total + (PAGE_SIZE - 1)) / 10);
        //查找所有销售数据
        List<CmsUser> userList = us.findAll();
        model.addAttribute("userList", userList);
        model.addAttribute("customerPagers", customerPagers);
        return "customer/customer-page-list";
    }
}



