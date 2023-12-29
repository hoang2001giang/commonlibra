package com.hoang2001giang.Libra.product.data;

import com.hoang2001giang.Libra.auth.data.User;
import com.hoang2001giang.Libra.category.data.Category;
import com.hoang2001giang.Libra.file.data.FileEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="products")
public class Product {
    @Id
    private String id = UUID.randomUUID().toString();
    private String slug;
    private String name;
    @Column(unique = true, nullable = false)
    private String code;
    @Column(columnDefinition = "TEXT")
    private String colorCodes;
    private int price;
    private String discount;
    private String sellingPrice;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "TEXT")
    private String thumbnail;
    private String status;
    @Column(columnDefinition = "TEXT")
    private String note;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;
}
