package com.naitech.domain.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.naitech.domain.persistence.Health_fitness;
import com.naitech.domain.persistence.Member;

import java.io.Serializable;

public class HealthFitnessDto implements Serializable {

    private double week_goal;
    private double current_amount;
    //private Long member;

    public HealthFitnessDto() {
    }

    public HealthFitnessDto(Health_fitness health_fitness) {
        this.week_goal = health_fitness.getWeek_goal();
        this.current_amount =health_fitness.getCurrent_amount();
        //this.member= health_fitness.getIdNumber().getIdNUmber();
    }

    @JsonIgnore
    public Health_fitness buildHealth(Member member){
        return new Health_fitness(null,this.getWeek_goal(), this.getCurrent_amount(), member);
    }

    public HealthFitnessDto(double week_goal, double current_amount) {
        this.week_goal = week_goal;
        this.current_amount = current_amount;
    }

    public HealthFitnessDto(double week_goal, double current_amount, Long member) {
        this.week_goal = week_goal;
        this.current_amount = current_amount;
        //this.member = member;
    }

    public double getWeek_goal() {
        return week_goal;
    }

    public void setWeek_goal(double week_goal) {
        this.week_goal = week_goal;
    }

    public double getCurrent_amount() {
        return current_amount;
    }

    public void setCurrent_amount(double current_amount) {
        this.current_amount = current_amount;
    }

  /*  public Long getMember() {
        return member;
    }

    public void setMember(Long member) {
        this.member = member;
    }*/

    @Override
    public String toString() {
        return "HealthFitnessDto{" +
                "week_goal=" + week_goal +
                ", current_amount=" + current_amount +
                //", member id=" + member +
                '}';
    }
}
