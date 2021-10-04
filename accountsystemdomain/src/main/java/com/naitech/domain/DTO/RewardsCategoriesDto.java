package com.naitech.domain.DTO;

import com.naitech.domain.persistence.RewardsCategories;

public class RewardsCategoriesDto {
    private String category_Name;
    private String category_Type;

    public RewardsCategoriesDto() {
    }

    public RewardsCategoriesDto(RewardsCategories rewardsCategories) {
        this.category_Name = rewardsCategories.getCategory_Name();
        this.category_Type = rewardsCategories.getCategory_Type();
    }

    public RewardsCategoriesDto(String category_Name, String category_Type) {
        this.category_Name = category_Name;
        this.category_Type = category_Type;
    }

    public String getCategory_Name() {
        return category_Name;
    }

    public void setCategory_Name(String category_Name) {
        this.category_Name = category_Name;
    }

    public String getCategory_Type() {
        return category_Type;
    }

    public void setCategory_Type(String category_Type) {
        this.category_Type = category_Type;
    }

    @Override
    public String toString() {
        return "RewardsCategoriesDto{" +
                "category_Name='" + category_Name + '\'' +
                ", category_Type='" + category_Type + '\'' +
                '}';
    }
}
