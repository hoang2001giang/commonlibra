package com.hoang2001giang.Libra.category.data;

import com.hoang2001giang.Libra.auth.data.User;
import com.hoang2001giang.Libra.product.data.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="Categories")
public class Category {
    @Id
    private String id = UUID.randomUUID().toString();
    @Column(nullable = false, unique = true)
    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
