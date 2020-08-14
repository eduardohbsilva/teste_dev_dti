package com.silva.stock_system.service.impl;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silva.stock_system.model.Product;
import com.silva.stock_system.repository.ProductRepository;
import com.silva.stock_system.service.ProductService;
import com.silva.stock_system.service.dto.ProductDTO;

/**
 * Service Implementation for managing {@link Product}.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        log.debug("Request to save Product : {}", productDTO);
        
        if(productDTO.getName() != null && productDTO.getName().length() > 0 && productDTO.getName().length() <= 100) {
    		if(productDTO.getQuantity() != null && productDTO.getQuantity() > 0) {
    			if(productDTO.getValue() != null && productDTO.getValue().compareTo(new BigDecimal(0)) > 0) {
    				Product product = new Product(productDTO);
                    product = productRepository.save(product);
                    return new ProductDTO(product);
    			}else {
    				throw new ValidationException("Insira um nome válido para o produto!");
    			}
    		}else {
    			throw new ValidationException("Insira uma quantidade válida para o produto!");
			}
    	}else {
    		throw new ValidationException("Insira um valor válido para o produto!");
		}
        
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        log.debug("Request to get all Products");
        
        List<ProductDTO> result = new ArrayList<>();
        List<Product> products = productRepository.findAll();
        
        for(Product product : products) {
        	result.add(new ProductDTO(product));
        }
        
        return result;
    }


    @Override
    @Transactional(readOnly = true)
    public ProductDTO findOne(Long id) {
        log.debug("Request to get Product : {}", id);
        Optional<Product> optional = productRepository.findById(id);
        
        if(optional.isPresent()) {
            return new ProductDTO(optional.get());
        }
        
        throw new ValidationException("O produto com o id " + id + " não foi encontrado!");
        
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Product : {}", id);
        productRepository.deleteById(id);
    }
}
