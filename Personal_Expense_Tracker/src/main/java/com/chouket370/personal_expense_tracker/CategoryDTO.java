package com.chouket370.personal_expense_tracker;

public class CategoryDTO {
    private Integer id;
    private String name;
    private Integer userId;

    public CategoryDTO() {}

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        if (category.getUser() != null) {
            this.userId = category.getUser().getId();
        }
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
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
