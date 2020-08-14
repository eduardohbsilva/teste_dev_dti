package com.silva.stock_system.service.dto;

import java.math.BigDecimal;

import com.silva.stock_system.model.Product;

/**
 * A DTO for the {@link br.com.silva.domain.Product} entity.
 */
public class ProductDTO {
    
    private Long id;

    private String name;

    private Integer quantity;

    private BigDecimal value;
    
    public ProductDTO() {
		// Auto-generated constructor stub
	}
    
    public ProductDTO(Product product) {
    	this.id = product.getId();
    	this.name = product.getName();
    	this.quantity = product.getQuantity();
    	this.value = product.getValue();
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

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
