package com.silva.stock_system.service;

import com.silva.stock_system.service.dto.UserDTO;

/**
 * Service Interface for managing {@link br.com.silva.domain.Product}.
 */
public interface UserService {
	
	/**
     * Create a user.
     *
     * @param userDTO the entity to save.
     * @return the persisted entity.
     */
	UserDTO createUser(UserDTO userDTO);
}
