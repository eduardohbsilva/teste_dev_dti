package com.silva.stock_system.model;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.silva.stock_system.service.dto.ProductDTO;

/**
 * A Product.
 */
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;

    @NotNull
    @Min(value = 1)
    @Column(name = "quantity")
    private Integer quantity;

    @NotNull
    @DecimalMin(value = "1.00")
    @Column(name = "value", precision = 21, scale = 2)
    private BigDecimal value;
    
    public Product() {
		// Auto-generated constructor stub
	}

    public Product(ProductDTO productDTO) {
    	this.id = productDTO.getId();
		this.name = productDTO.getName();
		this.quantity = productDTO.getQuantity();
		this.value = productDTO.getValue();
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Product name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Product quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Product value(BigDecimal value) {
        this.value = value;
        return this;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
