package com.hoang2001giang.Libra.book.data;


import com.hoang2001giang.Libra.auth.data.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name="books")
public class Book {
    @Id
    private String id = UUID.randomUUID().toString();
    @Column(nullable = false)
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
}
