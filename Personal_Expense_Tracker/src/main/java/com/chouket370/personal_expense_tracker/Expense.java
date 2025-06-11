package com.chouket370.personal_expense_tracker;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal amount;
    private String description;
    private Date date;



    @ManyToOne
    @JoinColumn(name="category_id")
    @NotNull(message = "La catégorie est obligatoire")
    @JsonBackReference("category-expenses")
    private Category category;

    public Expense(BigDecimal  amount, String description, Date date,Category category) {

        this.amount = amount;
        this.description = description;
        this.date = date;
        this.category = category;

    }
    public Expense() {}

    public Integer getId() {
        return id;
    }

    public BigDecimal  getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }



    public void setId(Integer id) {
        this.id = id;
    }

    public void setAmount(BigDecimal  amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
