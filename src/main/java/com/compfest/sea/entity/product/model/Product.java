package com.compfest.sea.entity.product.model;

import com.compfest.sea.entity.category.Category;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="\"products\"")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="price")
    private Integer price;
    @Column(name="quantity", nullable = false)
    private Integer quantity;
    @Column(name="merchantId", nullable = false)
    private Integer merchantId;
    @Column(name="category")
    private Category category;
    @Column(name="active", columnDefinition = "boolean default true")
    private Boolean active = true;
}
