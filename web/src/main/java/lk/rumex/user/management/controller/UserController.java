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
    List<User> all = userService.findAll();
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
