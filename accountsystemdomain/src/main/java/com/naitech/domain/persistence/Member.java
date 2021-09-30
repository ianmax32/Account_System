package com.naitech.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="Members")
public class Member implements Serializable {
    private Long idNUmber;
    private String name;
    private String surname;
    private LocalDate dob;
    private String gender;
    private int plays;
    private Spending spendings;
    private Health_fitness health_fitness;
    private Driving driving;
    private List<Transactions> transactions;

    public Member() {
    }

    public Member(Long idNUmber, String name, String surname, LocalDate dob, String gender, int plays) {
        this.idNUmber = idNUmber;
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.gender = gender;
        this.plays = plays;
    }

    public Member(Long idNUmber, String name, String surname, LocalDate dob, String gender, int plays, Spending spendings, Health_fitness health_fitness, Driving driving, List<Transactions> transactions) {
        this.idNUmber = idNUmber;
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.gender = gender;
        this.plays = plays;
        this.spendings = spendings;
        this.health_fitness = health_fitness;
        this.driving = driving;
        this.transactions = transactions;
    }

    @Id
    @SequenceGenerator(name="NAITECH_GENERIC_SEQ",sequenceName = "AS_NAITECH_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NAITECH_GENERIC_SEQ")
    @Column(name="Member_ID")
    public Long getIdNUmber() {
        return idNUmber;
    }

    public void setIdNUmber(Long idNUmber) {
        this.idNUmber = idNUmber;
    }

    @Column(name="Member_Name")
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Column(name="Member_Surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name="Member_DOB")
    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Column(name="Member_Gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name="Member_Plays")
    public int getPlays() {
        return plays;
    }

    public void setPlays(int plays) {
        this.plays = plays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return plays == member.plays && Objects.equals(idNUmber, member.idNUmber) && Objects.equals(name, member.name) && Objects.equals(surname, member.surname) && Objects.equals(dob, member.dob) && Objects.equals(gender, member.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNUmber, name, surname, dob, gender, plays);
    }

    @OneToOne(targetEntity = Spending.class,fetch = FetchType.LAZY,optional = true,mappedBy = "idNumber",cascade = CascadeType.PERSIST)
    public Spending getSpendings() {
        return spendings;
    }

    public void setSpendings(Spending spendings) {
        this.spendings = spendings;
    }

    @OneToOne(targetEntity = Health_fitness.class,fetch = FetchType.LAZY,optional = true,mappedBy = "idNumber")
    public Health_fitness getHealth_fitness() {
        return health_fitness;
    }

    public void setHealth_fitness(Health_fitness health_fitness) {
        this.health_fitness = health_fitness;
    }

    @OneToOne(targetEntity = Driving.class,fetch = FetchType.LAZY,optional = true,mappedBy = "idNumber")
    public Driving getDriving() {
        return driving;
    }

    public void setDriving(Driving driving) {
        this.driving = driving;
    }

    @OneToMany(targetEntity = Transactions.class,fetch = FetchType.LAZY,mappedBy = "member_id")
    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Member{" +
                "idNUmber='" + idNUmber + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", plays=" + plays +
                '}';
    }
}
