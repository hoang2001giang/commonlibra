package com.hoang2001giang.Libra.auth.data;

import javax.persistence.*;

import com.hoang2001giang.Libra.book.data.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="users")
public class User {
    @Id
    private String id = UUID.randomUUID().toString();
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="users_roles",
            joinColumns = @JoinColumn(
                    name = "userId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "roleId", referencedColumnName = "id")
    )
    private List<Role> roles;

    @OneToMany(mappedBy="user")
    private List<Book> books;
}
