package com.chouket370.personal_expense_tracker;


import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
    public Expense getExpenseById(Integer id) {
        return expenseRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + " not found"));
    }
    public Expense saveExpense(Expense expense) {

        return expenseRepository.save(expense);
    }
    public void deleteExpense(Integer id) {
        expenseRepository.deleteById(id);
    }
    public List<Expense> getExpensesByCategoryId(Integer categoryId) {
        return expenseRepository.findByCategoryId(categoryId);
    }
    public BigDecimal getTotalAmountByCategoryId(Integer categoryId) {
        return expenseRepository.getTotalAmountByCategoryId(categoryId);
    }
    public List<Expense> getExpensesByDateRange(Date from, Date to) {
        return expenseRepository.findByDateRange(from, to);
    }
}
