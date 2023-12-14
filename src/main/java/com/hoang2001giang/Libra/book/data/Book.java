package com.hoang2001giang.Libra.book.data;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name="books")
public class Book {
    @Id
    private String id;
    private String userId;
    private String name;
    private String description;
}
