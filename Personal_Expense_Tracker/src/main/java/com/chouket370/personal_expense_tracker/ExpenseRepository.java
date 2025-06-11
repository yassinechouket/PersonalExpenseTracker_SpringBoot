package com.chouket370.personal_expense_tracker;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer>{

    List<Expense> findByCategoryId(Integer categoryId);
    @Query("SELECT e FROM Expense e WHERE e.date BETWEEN :startDate AND :endDate")
    List<Expense> findByDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT SUM(e.amount) FROM Expense e WHERE e.category.id = ?1")
    BigDecimal getTotalAmountByCategoryId(Integer categoryId);

}