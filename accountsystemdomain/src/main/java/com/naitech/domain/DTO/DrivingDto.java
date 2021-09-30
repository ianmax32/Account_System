package com.naitech.domain.DTO;

import com.naitech.domain.persistence.Driving;
import com.naitech.domain.persistence.Member;

import java.io.Serializable;

public class DrivingDto implements Serializable {
    private double week_goal_km;
    private double km;
    private Long member;


    public DrivingDto() {
    }

    public DrivingDto(Driving driving) {
        super();
        this.week_goal_km = driving.getWeek_goal_km();
        this.km = driving.getKm();
        this.member =driving.getIdNumber().getIdNUmber();

    }

    public DrivingDto(double week_goal_km, double km, Long member) {
        this.week_goal_km = week_goal_km;
        this.km = km;
        this.member = member;
    }

    /*public DrivingDto buildDriving(Member member){
        return new DrivingDto(member);
    }*/

    public double getWeek_goal_km() {
        return week_goal_km;
    }


    public void setWeek_goal_km(double week_goal_km) {
        this.week_goal_km = week_goal_km;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public Long getMember() {
        return member;
    }

    public void setMember(Long member) {
        this.member = member;
    }



    @Override
    public String toString() {
        return "DrivingDto{" +
                "week_goal_km=" + week_goal_km +
                ", km=" + km +
                ", member=" + member +
                '}';
    }
}
