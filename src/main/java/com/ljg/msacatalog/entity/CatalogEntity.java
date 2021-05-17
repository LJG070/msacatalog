package com.ljg.msacatalog.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="catalog")
public class CatalogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120, unique = true)
    private String productId;
    @Column(nullable = false, length = 120, unique = true)
    private String productName;
    @Column(nullable = false, length = 120, unique = true)
    private Integer stock;
    @Column(nullable = false, length = 120, unique = true)
    private Integer unitPrice;
    @Column(nullable = true, updatable = false, length = 120, unique = true)
    @CreationTimestamp
    private LocalDateTime createdAt;
}
