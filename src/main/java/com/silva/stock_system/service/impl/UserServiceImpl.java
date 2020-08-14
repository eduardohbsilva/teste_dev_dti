package com.silva.stock_system.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silva.stock_system.config.PasswordEncoder;
import com.silva.stock_system.model.User;
import com.silva.stock_system.repository.UserRepository;
import com.silva.stock_system.service.UserService;
import com.silva.stock_system.service.dto.UserDTO;

/**
 * Service Implementation for managing {@link User}.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user = new User(userDTO);
		user.setPassword(PasswordEncoder.encoder(userDTO.getPassword()));
        userRepository.save(user);
        log.debug("Created User: {}", user);
        return new UserDTO(user);
	}
}
