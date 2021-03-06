package com.example.web;

import com.example.domain.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller //mvcモデルのcontrollerであることを示す
@RequestMapping("customers")
public class CustomerController {
	
    @Autowired //diによるインジェクション
    CustomerService customerService;

    @ModelAttribute //formの初期化。@RequestMappingの前に実行される。
    CustomerForm setUpForm() {
        return new CustomerForm();
    }

    @GetMapping //httpリクエストをgetメソッドで受付
    String list(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customersModel", customers);
        return "customers/list";
    }

    @PostMapping(path = "create") //httpリクエストをpostメソッドで受付。@Validatedでbean validation。結果はBindingResultに。
    String create(@Validated CustomerForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return list(model);
        }
        
        //System.out.println(form.getFirstName());
        //System.out.println(form.getLastName());
        
        Customer customer = new Customer();
        BeanUtils.copyProperties(form, customer);
        customerService.create(customer);
        return "redirect:/customers";
    }

    @GetMapping(path = "edit", params = "form") //RequestParamのマッピング
    String editForm(@RequestParam Integer id, CustomerForm form) {
        Customer customer = customerService.findOne(id);
        BeanUtils.copyProperties(customer, form);
        return "customers/edit";
    }

    @PostMapping(path = "edit")
    String edit(@RequestParam Integer id, @Validated CustomerForm form, BindingResult result) {
        if (result.hasErrors()) {
            return editForm(id, form);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(form, customer);
        customer.setId(id);
        customerService.update(customer);
        return "redirect:/customers";
    }

    @GetMapping(path = "edit", params = "goToTop")
    String goToTop() {
        return "redirect:/customers";
    }

    @PostMapping(path = "delete")
    String delete(@RequestParam Integer id) {
        customerService.delete(id);
        return "redirect:/customers";
    }
}