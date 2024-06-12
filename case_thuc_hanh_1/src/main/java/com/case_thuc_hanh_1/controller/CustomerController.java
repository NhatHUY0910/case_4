package com.case_thuc_hanh_1.controller;

import com.case_thuc_hanh_1.model.Customer;
import com.case_thuc_hanh_1.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public ModelAndView getAllCustomers() {
        ModelAndView modelAndView = new ModelAndView("customer_list");
        modelAndView.addObject("customers", customerService.getAllCustomer());
        return modelAndView;
    }

    @GetMapping("/create-form")
    public ModelAndView getCreateForm() {
        ModelAndView modelAndView = new ModelAndView("customer_create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/save-customer")
    public ModelAndView saveCustomer(@ModelAttribute Customer customer) {
        customerService.saveCustomer(customer);
        ModelAndView modelAndView = new ModelAndView("customer_create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }
}
