package com.case_thuc_hanh.service;

import com.case_thuc_hanh.model.Transaction;

import java.util.List;

public interface ITransactionService {
    List<Transaction> getAllTransactions();
    Transaction getTransactionById(Long id);
    void saveTransaction(Transaction transaction);
    void updateTransaction(Transaction transaction);
    void deleteTransaction(Long id);
}
