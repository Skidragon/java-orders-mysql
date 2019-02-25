package com.lambdaschool.ordersmysql.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long customercode;

    private String name;

    private String city;

    private long workingarea;

    private long country;

    private String grade;

    private double openingamount;

    private double receiveamount;

    private double outstandingamount;

    private String phone;

    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false)
    @JsonIgnore
    private Agent agent;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "customer")
    @JsonIgnore
    private Set<Order> orders;

    public Customer() {
    }

    public long getCustomercode() {
        return customercode;
    }

    public void setCustomercode(long customercode) {
        this.customercode = customercode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getWorkingarea() {
        return workingarea;
    }

    public void setWorkingarea(long workingarea) {
        this.workingarea = workingarea;
    }

    public long getCountry() {
        return country;
    }

    public void setCountry(long country) {
        this.country = country;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getOpeningamount() {
        return openingamount;
    }

    public void setOpeningamount(double openingamount) {
        this.openingamount = openingamount;
    }

    public double getReceiveamount() {
        return receiveamount;
    }

    public void setReceiveamount(double receiveamount) {
        this.receiveamount = receiveamount;
    }

    public double getOutstandingamount() {
        return outstandingamount;
    }

    public void setOutstandingamount(double outstandingamount) {
        this.outstandingamount = outstandingamount;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
