package com.naitech.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="Spending")
public class Spending implements Serializable {
    private Long id;
    private double weekly_goal;
    private double current_amount_spent;
    private Member idNumber;

    public Spending() {
    }

    public Spending(Long id, double weekly_goal, double current_amount_spent, Member idNumber) {
        this.id = id;
        this.weekly_goal = weekly_goal;
        this.current_amount_spent = current_amount_spent;
        this.idNumber = idNumber;
    }

    @Id
    @SequenceGenerator(name="Spending_GENERIC_SEQ",sequenceName = "AS_Spending_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Spending_GENERIC_SEQ")
    @Column(name="Spending_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="Current_Amount_Spent")
    public double getCurrent_amount_spent() {
        return current_amount_spent;
    }

    public void setCurrent_amount_spent(double current_amount_spent) {
        this.current_amount_spent = current_amount_spent;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Member_ID")
    public Member getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Member idNumber) {
        this.idNumber = idNumber;
    }

    @Column(name = "weekly_goal")
    public double getWeekly_goal() {
        return weekly_goal;
    }

    public void setWeekly_goal(double weekly_goal) {
        this.weekly_goal = weekly_goal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spending spending = (Spending) o;
        return Double.compare(spending.current_amount_spent, current_amount_spent) == 0 && Objects.equals(id, spending.id) && Objects.equals(idNumber, spending.idNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, current_amount_spent, idNumber);
    }

    @Override
    public String toString() {
        return "Spending{" +
                "id=" + id +
                ", current_amount_spent=" + current_amount_spent +
                ", idNumber='" + idNumber + '\'' +
                '}';
    }
}
