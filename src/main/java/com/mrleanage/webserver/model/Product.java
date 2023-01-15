package com.mrleanage.webserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//to have getters and setters in Spring
@Getter
@Setter

//to have default and parameterised constructors
@AllArgsConstructor
@NoArgsConstructor

//to use this class as a JPA(Java Persistence API) Entity
@Entity
@Table(name = "products")
public class Product {

    //to set primary Key with JPA
    @Id
    //to make primary key auto generated
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     *     declaring other columns in the table. Here if we want to have
     *     a custom name as column name rather than data object name, we can use @Column Annotation.
     *     If we want to have same data object name as column name in DB, just leave without @Column Annotation
     *     then it will automatically create table columns by default
     */

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "expireDate")
    private String expireDate;


}
