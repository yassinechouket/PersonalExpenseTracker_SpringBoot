package com.chouket370.personal_expense_tracker;

public class CategoryCreateRequest {
    private String name;
    private Integer userId;

    public CategoryCreateRequest() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
