package com.case_thuc_hanh_1.controller;

import com.case_thuc_hanh_1.model.Transaction;
import com.case_thuc_hanh_1.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    @GetMapping
    public ModelAndView findAll() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        ModelAndView modelAndView = new ModelAndView("transaction_list");
        modelAndView.addObject("transactions", transactions);
        return modelAndView;
    }

    @GetMapping("/create-form")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("transaction_create");
        modelAndView.addObject("transaction", new Transaction());
        return modelAndView;
    }

    @PostMapping("/save-transaction")
    public String save(@ModelAttribute("transaction") Transaction transaction) {
        transactionService.saveTransaction(transaction);
        return "redirect:/transactions";
    }
}
