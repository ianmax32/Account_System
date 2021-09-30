package com.naitech.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Health_Fitness")
public class Health_fitness implements Serializable {
    private Long id;
    private double week_goal;
    private double current_amount;
    private Member idNumber;

    public Health_fitness() {
    }

    public Health_fitness(Long id, double week_goal, double current_amount, Member idNumber) {
        this.id = id;
        this.week_goal = week_goal;
        this.current_amount = current_amount;
        this.idNumber = idNumber;
    }

    @Id
    @SequenceGenerator(name="NAITECH_GENERIC_SEQ",sequenceName = "AS_NAITECH_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NAITECH_GENERIC_SEQ")
    @Column(name="Health_fitness_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="Health_fitness_Week_Goal")
    public double getWeek_goal() {
        return week_goal;
    }

    public void setWeek_goal(double week_goal) {
        this.week_goal = week_goal;
    }

    @Column(name="Health_fitness_Current_Amount")
    public double getCurrent_amount() {
        return current_amount;
    }

    public void setCurrent_amount(double current_amount) {
        this.current_amount = current_amount;
    }

    @OneToOne
    @JoinColumn(name="Member_ID")
    public Member getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Member idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Health_fitness that = (Health_fitness) o;
        return Double.compare(that.week_goal, week_goal) == 0 && Double.compare(that.current_amount, current_amount) == 0 && Objects.equals(id, that.id) && Objects.equals(idNumber, that.idNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, week_goal, current_amount, idNumber);
    }

    @Override
    public String toString() {
        return "Health_fitness{" +
                "id=" + id +
                ", week_goal=" + week_goal +
                ", current_amount=" + current_amount +
                ", idNumber='" + idNumber + '\'' +
                '}';
    }
}
