package com.momentum.active.activeshoppe.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="product")
@ToString
@Getter
@Setter
public class ProductDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="code")
    @JsonIgnore
    private int code;

    @Column(name="name")
    private String name;

    @Column(name="cost")
    private int cost;


//    @ManyToOne(cascade = {PERSIST, MERGE})
//    @JoinColumn(name="id_customer", nullable=false)
//    @JsonIgnore
//    private Customer customer;

}

