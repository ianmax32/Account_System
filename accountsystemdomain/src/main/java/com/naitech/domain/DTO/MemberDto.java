package com.naitech.domain.DTO;

import com.naitech.domain.persistence.Driving;
import com.naitech.domain.persistence.Health_fitness;
import com.naitech.domain.persistence.Member;
import com.naitech.domain.persistence.Spending;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class MemberDto implements Serializable {
    private String name;
    private String surname;
    private LocalDate dob;
    private String gender;
    private int plays;
    private DrivingDto drivingDto;
    private SpendingDto spendingDto;
    private HealthFitnessDto healthFitnessDto;


    public MemberDto() {
    }

    public MemberDto(Member member) {
        this.name = member.getName();
        this.surname = member.getSurname();
        this.dob = member.getDob();
        this.gender = member.getGender();
        this.plays = member.getPlays();
        if(null != member.getDriving()){
            this.drivingDto = new DrivingDto(member.getDriving());
        }
        if(null != member.getHealth_fitness()){
            this.healthFitnessDto = new HealthFitnessDto(member.getHealth_fitness());
        }
        if(null != member.getSpendings()){
            this.spendingDto = new SpendingDto(member.getSpendings());
        }


    }

    public MemberDto(String name, String surname, LocalDate dob, String gender, int plays) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.gender = gender;
        this.plays = plays;
    }

    public MemberDto(String name, String surname, LocalDate dob, String gender, int plays, DrivingDto drivingDto, SpendingDto spendingDto, HealthFitnessDto healthFitnessDto, List<TransactionsDto> transactionsDto) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.gender = gender;
        this.plays = plays;
        this.drivingDto = drivingDto;
        this.spendingDto = spendingDto;
        this.healthFitnessDto = healthFitnessDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPlays() {
        return plays;
    }

    public void setPlays(int plays) {
        this.plays = plays;
    }

    public DrivingDto getDrivingDto() {
        return drivingDto;
    }

    public void setDrivingDto(DrivingDto drivingDto) {
        this.drivingDto = drivingDto;
    }

    public SpendingDto getSpendingDto() {
        return spendingDto;
    }

    public void setSpendingDto(SpendingDto spendingDto) {
        this.spendingDto = spendingDto;
    }

    public HealthFitnessDto getHealthFitnessDto() {
        return healthFitnessDto;
    }

    public void setHealthFitnessDto(HealthFitnessDto healthFitnessDto) {
        this.healthFitnessDto = healthFitnessDto;
    }


    @Override
    public String toString() {
        return "MemberDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", plays=" + plays +
                ", driving details=" + drivingDto +
                ", spending details=" + spendingDto +
                ", healthFitness details=" + healthFitnessDto +
                '}';
    }
}
