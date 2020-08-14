package com.silva.stock_system.service;

import java.util.List;

import com.silva.stock_system.service.dto.ProductDTO;

/**
 * Service Interface for managing {@link br.com.silva.domain.Product}.
 */
public interface ProductService {

    /**
     * Save a product.
     *
     * @param productDTO the entity to save.
     * @return the persisted entity.
     * @throws Exception 
     */
    ProductDTO save(ProductDTO productDTO);

    /**
     * Get all the products.
     *
     * @return the list of entities.
     */
    List<ProductDTO> findAll();


    /**
     * Get the "id" product.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    ProductDTO findOne(Long id);

    /**
     * Delete the "id" product.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
