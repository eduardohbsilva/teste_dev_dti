package com.silva.stock_system.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silva.stock_system.service.ProductService;
import com.silva.stock_system.service.dto.ProductDTO;

/**
 * REST controller for managing {@link com.silva.stock_system.model.Product}.
 */
@RestController
@RequestMapping("/api")
public class ProductController {

    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * {@code POST  /products} : Create a new product.
     *
     * @param productDTO the productDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new productDTO, or with status {@code 400 (Bad Request)} if the product has already an ID.
     * @throws Exception 
     */
    @PostMapping("/products")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO) throws Exception {
        log.debug("REST request to save Product : {}", productDTO);
        ProductDTO result = productService.save(productDTO);
        return ResponseEntity.created(new URI("/api/products/" + result.getId())).body(result);
    }

    /**
     * {@code PUT  /products} : Updates an existing product.
     *
     * @param productDTO the productDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated productDTO,
     * or with status {@code 400 (Bad Request)} if the productDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the productDTO couldn't be updated.
     * @throws Exception 
     */
    @PutMapping("/products")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductDTO> updateProduct(@Valid @RequestBody ProductDTO productDTO) throws Exception {
        log.debug("REST request to update Product : {}", productDTO);
        ProductDTO result = productService.save(productDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /products} : get all the products.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of products in body.
     */
    @GetMapping("/products")
    public List<ProductDTO> getAllProducts() {
        log.debug("REST request to get all Products");
        return productService.findAll();
    }

    /**
     * {@code GET  /products/:id} : get the "id" product.
     *
     * @param id the id of the productDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the productDTO.
     */
    @GetMapping("/products/{id}")
    public ProductDTO getProduct(@PathVariable Long id) {
        log.debug("REST request to get Product : {}", id);
        return productService.findOne(id);
    }

    /**
     * {@code DELETE  /products/:id} : delete the "id" product.
     *
     * @param id the id of the productDTO to delete.
     * @return the {@link ResponseEntity}.
     */
    @DeleteMapping("/products/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        log.debug("REST request to delete Product : {}", id);
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
