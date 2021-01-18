package lk.rumex.user.management.controller;

import lk.rumex.user.management.dto.CreateUserDTO;
import lk.rumex.user.management.model.User;
import lk.rumex.user.management.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public List<User> getAllUsers() {
    logger.info("Get all user method executing started");

    List<User> all = userService.findAll();

    logger.info("Get all user method executing stopped");

    return all;
  }

  @RequestMapping(value = "/users", method = RequestMethod.POST)
  public User createUser(@RequestBody CreateUserDTO createUserDTO) {
    logger.info("Create user method executing started");

    User user = userService.create(createUserDTO);

    logger.info("Create user method executing stopped");

    return user;
  }

  @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
  public Long deleteUser(@PathVariable(name = "id") Long id) {
    logger.info("Delete user method executing started");

    Long delete = userService.delete(id);

    logger.info("Delete user method executing stopped");

    return delete;
  }

  @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
  public User findById(@PathVariable(name = "id") Long id) {
    logger.info("Get user by id method executing started");

    User byId = userService.findById(id);

    logger.info("Get user by id method executing stopped");

    return byId;
  }

}
