package com.springboot.jpa.hibernate.h2.example.book;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private Set<BookPublisher> bookPublishers = new HashSet<>();

    public Publisher(String name) {
        this.name = name;
    }
}
