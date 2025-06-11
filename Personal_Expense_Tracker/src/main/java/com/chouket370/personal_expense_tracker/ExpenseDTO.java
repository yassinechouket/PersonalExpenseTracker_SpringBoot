package com.chouket370.personal_expense_tracker;

import java.math.BigDecimal;
import java.util.Date;

public class ExpenseDTO {
    private Long id;
    private BigDecimal amount;
    private String description;
    private Date date;
    private String categoryName;
    private String userName;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public ExpenseDTO(Long id, BigDecimal amount, String description, Date date, String categoryName, String userName) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.categoryName = categoryName;
        this.userName = userName;
    }
    public ExpenseDTO() {}
}