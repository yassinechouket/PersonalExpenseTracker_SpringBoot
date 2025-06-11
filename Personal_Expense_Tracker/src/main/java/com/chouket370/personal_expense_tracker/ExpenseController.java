package com.chouket370.personal_expense_tracker;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Expense")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }
    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Integer id) {
        return expenseService.getExpenseById(id);
    }
    @PostMapping("/save")
    public Expense saveExpense(@RequestBody Expense expense) {
        return expenseService.saveExpense(expense);
    }
    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Integer id){
        expenseService.deleteExpense(id);
    }
    @GetMapping("categoryId/{categoryId}")
    public List<Expense> getExpensesByCategoryId(@PathVariable Integer categoryId) {
        return expenseService.getExpensesByCategoryId(categoryId);
    }
    @GetMapping("/total/category/{categoryId}")
    public BigDecimal getTotalByCategoryId(@PathVariable Integer categoryId) {
        return expenseService.getTotalAmountByCategoryId(categoryId);
    }

    @GetMapping("/date-range")
    public List<Expense> getExpensesByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date endDate) {
        return expenseService.getExpensesByDateRange(startDate, endDate);
    }

}
