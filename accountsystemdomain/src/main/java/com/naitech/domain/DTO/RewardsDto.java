package com.naitech.domain.DTO;

import com.naitech.domain.persistence.Rewards;

import java.io.Serializable;

public class RewardsDto implements Serializable {
    private String reward_name;
    private String reward_category_name;
    private double reward_amount;
    private Rewards rewards;

    public RewardsDto() {
    }

    public RewardsDto(Rewards rewards) {
        super();
        this.reward_name = rewards.getReward_name();
        this.reward_amount = rewards.getReward_amount();
        this.reward_category_name = rewards.getReward_category_id().getCategory_Name();
    }

    public RewardsDto(String reward_name, String reward_category_name, double reward_amount, Rewards rewards) {
        this.reward_name = reward_name;
        this.reward_category_name = reward_category_name;
        this.reward_amount = reward_amount;
        this.rewards = rewards;
    }

    public String getReward_name() {
        return reward_name;
    }

    public void setReward_name(String reward_name) {
        this.reward_name = reward_name;
    }

    public String getReward_category_name() {
        return reward_category_name;
    }

    public void setReward_category_name(String reward_category_name) {
        this.reward_category_name = reward_category_name;
    }

    public Rewards getRewards() {
        return rewards;
    }

    public void setRewards(Rewards rewards) {
        this.rewards = rewards;
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
                ", rewards=" + rewards +
                '}';
    }
}
