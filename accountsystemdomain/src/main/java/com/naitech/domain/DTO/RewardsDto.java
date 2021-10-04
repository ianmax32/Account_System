package com.naitech.domain.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.naitech.domain.persistence.Driving;
import com.naitech.domain.persistence.Member;
import com.naitech.domain.persistence.Rewards;
import com.naitech.domain.persistence.RewardsCategories;

import java.io.Serializable;

public class RewardsDto implements Serializable {
    private String reward_name;
    private RewardsCategoriesDto reward_category_name;
    private double reward_amount;

    public RewardsDto() {
    }

    public RewardsDto(Rewards rewards) {
        this.reward_name = rewards.getReward_name();
        this.reward_amount = rewards.getReward_amount();
        if(null != rewards.getReward_category_id()){
            this.reward_category_name = new RewardsCategoriesDto(rewards.getReward_category_id());
        }
    }

    public RewardsDto(String reward_name, RewardsCategoriesDto reward_category_name, double reward_amount) {
        this.reward_name = reward_name;
        this.reward_category_name = reward_category_name;
        this.reward_amount = reward_amount;
    }

    @JsonIgnore
    public Rewards buildReward(RewardsCategories reward){
        return new Rewards(null, this.getReward_name(), reward,this.getReward_amount());
    }

    public String getReward_name() {
        return reward_name;
    }

    public void setReward_name(String reward_name) {
        this.reward_name = reward_name;
    }

    public RewardsCategoriesDto getReward_category_name() {
        return reward_category_name;
    }

    public void setReward_category_name(RewardsCategoriesDto reward_category_name) {
        this.reward_category_name = reward_category_name;
    }

    public double getReward_amount() {
        return reward_amount;
    }

    public void setReward_amount(double reward_amount) {
        this.reward_amount = reward_amount;
    }

    @Override
    public String toString() {
        return "RewardsDto{" +
                "reward_name='" + reward_name + '\'' +
                ", reward_category_name='" + reward_category_name + '\'' +
                ", reward_amount=" + reward_amount +
                '}';
    }
}
