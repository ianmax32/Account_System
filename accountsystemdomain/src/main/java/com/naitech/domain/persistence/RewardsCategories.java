package com.naitech.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Rewards_Categories")
public class RewardsCategories implements Serializable {
    private Long category_id;
    private String category_Name;
    private String category_Type;
    private List<Rewards> rewards;

    public RewardsCategories() {
    }

    public RewardsCategories(Long category_id, String category_Name, String category_Type) {
        this.category_id = category_id;
        this.category_Name = category_Name;
        this.category_Type = category_Type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RewardsCategories that = (RewardsCategories) o;
        return Objects.equals(category_id, that.category_id) && Objects.equals(category_Name, that.category_Name) && Objects.equals(category_Type, that.category_Type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category_id, category_Name, category_Type);
    }

    @Id
    @SequenceGenerator(name="RC_GENERIC_SEQ",sequenceName = "AS_RC_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RC_GENERIC_SEQ")
    @Column(name="Rewards_Category_ID")
    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    @Column(name="Rewards_Category_Name")
    public String getCategory_Name() {
        return category_Name;
    }

    public void setCategory_Name(String category_Name) {
        this.category_Name = category_Name;
    }

    @Column(name="Rewards_Category_Type",unique = true)
    public String getCategory_Type() {
        return category_Type;
    }

    public void setCategory_Type(String category_Type) {
        this.category_Type = category_Type;
    }

    @OneToMany(targetEntity = Rewards.class, fetch = FetchType.LAZY, mappedBy = "reward_category_id")
    public List<Rewards> getRewards() {
        return rewards;
    }

    public void setRewards(List<Rewards> rewards) {
        this.rewards = rewards;
    }

    @Override
    public String toString() {
        return "Rewards_Categories{" +
                "category_id=" + category_id +
                ", category_Name='" + category_Name + '\'' +
                ", category_Type='" + category_Type + '\'' +
                '}';
    }
}
