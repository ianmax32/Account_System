package com.naitech.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Rewards")
public class Rewards implements Serializable {
    private Long reward_id;
    private String reward_name;
    private RewardsCategories reward_category_id;
    private double reward_amount;

    public Rewards() {
    }

    public Rewards(Long reward_id, String reward_name, RewardsCategories reward_category_id, double reward_amount) {
        this.reward_id = reward_id;
        this.reward_name = reward_name;
        this.reward_category_id = reward_category_id;
        this.reward_amount = reward_amount;
    }

    @Id
    @SequenceGenerator(name="NAITECH_GENERIC_SEQ",sequenceName = "AS_NAITECH_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NAITECH_GENERIC_SEQ")
    @Column(name="Reward_ID")
    public Long getReward_id() {
        return reward_id;
    }

    public void setReward_id(Long reward_id) {
        this.reward_id = reward_id;
    }

    @Column(name="Reward_Name")
    public String getReward_name() {
        return reward_name;
    }

    public void setReward_name(String reward_name) {
        this.reward_name = reward_name;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Rewards_Category_ID")
    public RewardsCategories getReward_category_id() {
        return reward_category_id;
    }

    public void setReward_category_id(RewardsCategories reward_category_id) {
        this.reward_category_id = reward_category_id;
    }

    @Column(name="Reward_Amount")
    public double getReward_amount() {
        return reward_amount;
    }

    public void setReward_amount(double reward_amount) {
        this.reward_amount = reward_amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rewards rewards = (Rewards) o;
        return Double.compare(rewards.reward_amount, reward_amount) == 0 && Objects.equals(reward_id, rewards.reward_id) && Objects.equals(reward_name, rewards.reward_name) && Objects.equals(reward_category_id, rewards.reward_category_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reward_id, reward_name, reward_category_id, reward_amount);
    }

    @Override
    public String toString() {
        return "Rewards{" +
                "reward_id=" + reward_id +
                ", reward_name='" + reward_name + '\'' +
                ", reward_category_id=" + reward_category_id +
                ", reward_amount=" + reward_amount +
                '}';
    }
}
