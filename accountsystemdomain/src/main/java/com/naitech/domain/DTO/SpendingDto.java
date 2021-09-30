package com.naitech.domain.DTO;

import com.naitech.domain.persistence.Spending;

import java.io.Serializable;

public class SpendingDto implements Serializable {
    private double weekly_goal;
    private double current_amount_spent;
    private Long member;
    //private Spending spending;

    public SpendingDto() {
    }

    public SpendingDto(Spending spending) {
        super();
        this.weekly_goal = spending.getWeekly_goal();
        this.current_amount_spent = spending.getCurrent_amount_spent();
        this.member = spending.getIdNumber().getIdNUmber();
    }

    public SpendingDto(double weekly_goal, double current_amount_spent, Long member) {
        this.weekly_goal = weekly_goal;
        this.current_amount_spent = current_amount_spent;
        this.member = member;
        //this.spending = spending;
    }

    public double getWeekly_goal() {
        return weekly_goal;
    }

    public void setWeekly_goal(double weekly_goal) {
        this.weekly_goal = weekly_goal;
    }

    public double getCurrent_amount_spent() {
        return current_amount_spent;
    }

    public void setCurrent_amount_spent(double current_amount_spent) {
        this.current_amount_spent = current_amount_spent;
    }

    public Long getMember() {
        return member;
    }

    public void setMember(Long member) {
        this.member = member;
    }

   /* public Spending getSpending() {
        return spending;
    }

    public void setSpending(Spending spending) {
        this.spending = spending;
    }*/

    @Override
    public String toString() {
        return "SpendingDto{" +
                "weekly_goal=" + weekly_goal +
                ", current_amount_spent=" + current_amount_spent +
                ", member=" + member +
                '}';
    }
}
