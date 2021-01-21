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
    logger.info("Find all users started");
    List<User> all = userService.findAll();
    logger.info("Find all users stopped");
    return all;
  }

  @RequestMapping(value = "/users", method = RequestMethod.POST)
  public User createUser(@RequestBody CreateUserDTO createUserDTO) {
    User user = userService.create(createUserDTO);
    return user;
  }

  @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
  public Long deleteUser(@PathVariable(name = "id") Long id) {
    Long delete = userService.delete(id);
    return delete;
  }

  @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
  public User findById(@PathVariable(name = "id") Long id) {
    User byId = userService.findById(id);
    return byId;
  }

}
