package com.naitech.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Driving")
public class Driving implements Serializable {
    private Long id;
    private double week_goal_km;
    private double km;
    private Member idNumber;

    public Driving() {
    }

    public Driving(Long id, double week_goal_km, double km, Member idNumber) {
        this.id = id;
        this.week_goal_km = week_goal_km;
        this.km = km;
        this.idNumber = idNumber;
    }

    @Id
    @SequenceGenerator(name="Driving_GENERIC_SEQ",sequenceName = "AS_Driving_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Driving_GENERIC_SEQ")
    @Column(name="Driving_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="Driving_Week_Goal")
    public double getWeek_goal_km() {
        return week_goal_km;
    }

    public void setWeek_goal_km(double week_goal_km) {
        this.week_goal_km = week_goal_km;
    }

    @Column(name="Driving_Current_Goal")
    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    @OneToOne(fetch = FetchType.LAZY)
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
        Driving driving = (Driving) o;
        return Double.compare(driving.week_goal_km, week_goal_km) == 0 && Double.compare(driving.km, km) == 0 && Objects.equals(id, driving.id) && Objects.equals(idNumber, driving.idNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, week_goal_km, km, idNumber);
    }

    @Override
    public String toString() {
        return "Driving{" +
                "id=" + id +
                ", week_goal_km=" + week_goal_km +
                ", current km=" + km +
                ", idNumber='" + idNumber + '\'' +
                '}';
    }
}
