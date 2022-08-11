package com.fariba.springrestdemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_tmp_customer", schema = "cmn")
@SequenceGenerator(name = "sq_customer",allocationSize = 1, sequenceName = "sq_tmp_customer",schema = "cmn")
public class Customer {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sq_customer")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public Customer(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
