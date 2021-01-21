package lk.rumex.user.management.service;

import lk.rumex.user.management.dto.CreateUserDTO;
import lk.rumex.user.management.exception.UserNotFoundException;
import lk.rumex.user.management.model.User;

import java.util.List;

public interface UserService {

  List<User> findAll();

  User create(CreateUserDTO createUserDTO);

  Long delete(Long id);

  User findById(Long id) throws UserNotFoundException;
}
