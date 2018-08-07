package com.easycms.controller;

import com.easycms.entity.CmsCustomer;
import com.easycms.service.CmsCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by IYFT on 2018/8/7.
 */
@Controller
@RequestMapping("/customer")
public class CmsCustomerController {
    @Autowired
    private CmsCustomerService ccs;

    @RequestMapping("/list")
    public String findAll(Model model){
        List<CmsCustomer> customerList =ccs.findAll();
     model.addAttribute("customerList",customerList);
        return "customer/customer-list";
    }

    @RequestMapping("/add")
    public String addCustomer(CmsCustomer customer){
        ccs.save(customer);
        return "customer/customer-list";
    }
    @RequestMapping("/delete")
    public void editCustomer(int id){
        ccs.delete(id);
    }
}
