package lk.rumex.user.management.controller;

import lk.rumex.user.management.dto.CreateUserDTO;
import lk.rumex.user.management.model.User;
import lk.rumex.user.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public List<User> getAllUsers() {
    return userService.findAll();
  }

  @RequestMapping(value = "/users", method = RequestMethod.POST)
  public User createUser(@RequestBody CreateUserDTO createUserDTO) {

    return userService.create(createUserDTO);
  }

  @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
  public Long deleteUser(@PathVariable(name = "id") Long id) {

    return userService.delete(id);
  }

  @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
  public User findById(@PathVariable(name = "id") Long id) {

    return userService.findById(id);
  }

}
