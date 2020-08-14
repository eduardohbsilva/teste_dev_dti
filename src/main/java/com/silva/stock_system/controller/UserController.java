package com.silva.stock_system.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silva.stock_system.service.UserService;
import com.silva.stock_system.service.dto.UserDTO;

/**
 * REST controller for managing users.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * {@code POST  /users}  : Creates a new user.
     *
     * @param userDTO the user to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new user.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/users")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) throws URISyntaxException {
        log.debug("REST request to save User : {}", userDTO);
        UserDTO newUser = userService.createUser(userDTO);
        return ResponseEntity.created(new URI("/api/users/" + newUser.getId())).body(newUser);
    }
}
