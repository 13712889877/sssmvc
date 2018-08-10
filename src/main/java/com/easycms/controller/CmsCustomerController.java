package com.easycms.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/customer")
public class CmsCustomerController {
    private static final Logger logger = Logger.getLogger(CmsCustomerController.class);
    @Autowired
    private CmsCustomerService ccs;
    @Resource(name = "cmsUserServiceImpl")
    private CmsUserService us;
    @Resource(name = "cmsLogServiceImpl")
    private CmsLogService ls;

    @RequestMapping("/list")
    public String findAll(ModelMap model) {
        List<CmsUser> userList = us.findAll();
        model.addAttribute("userList", userList);
        List<CmsCustomer> customerList = ccs.findAllCustomer();
        model.addAttribute("customerList", customerList);
        return "customer/customer-list";
    }

    @RequestMapping("/save")
    public String save(CmsCustomer customer) {
        ccs.save(customer);
        return "redirect:customer/customer-list";
    }

    @RequestMapping("/delete")
    public String delete(Integer customerId) {

        ccs.deleteById(customerId);
        return "redirect:/customer/list";
    }

    @RequestMapping("/beforeSave")
    public String beforeAdd(ModelMap model) {
        List<CmsUser> userList = us.findAll();
        model.addAttribute("userList", userList);
        return "customer/customer-add";
    }

    @RequestMapping("/deleteIn")
    public String deleteIn(HttpServletRequest req, ModelMap model) {
        String[] ids = req.getParameterValues("ids");
        if (ids != null) {
            List<String> list = new ArrayList<String>();
            for (String id : ids) {
                list.add(id);
            }
            ccs.deleteIn(list);
            logger.info("delete CmsCustomer name={" + ids + "}");

        }
        return "redirect:/customer/list";


    }

    @RequestMapping("/beforeEdit")
    public String beforeEdit(ModelMap model, int id) {
        CmsCustomer customer = ccs.findById(id);
        List<CmsUser> userList = us.findAll();
        model.addAttribute("userList", userList);
        model.addAttribute("customer", customer);
        return "customer/customer-edit";
    }
    @RequestMapping("edit")
    public String edit(CmsCustomer customer){
        ccs.update(customer);

        return "redirect:/customer/list";
    }

    @RequestMapping("salesSelect")
    public String salesSelect(int id){
return null;
    }


}



