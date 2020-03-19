package com.momentum.active.activeshoppe.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="customer")
@ToString
@Getter
@Setter
public class CustomerDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @JsonIgnore
    private int customerId;

    @Column(name="name")
    private String name;

    @Column(name="active_day_points")
    private int activeDayPoints;

}

