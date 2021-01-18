package lk.rumex.user.management.service.impl;

import lk.rumex.user.management.Repository.UserRepository;
import lk.rumex.user.management.dto.CreateUserDTO;
import lk.rumex.user.management.exception.UserNotFoundException;
import lk.rumex.user.management.model.User;
import lk.rumex.user.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public User create(CreateUserDTO createUserDTO) {

    User user = new User();

    user.setAge(createUserDTO.getAge());

    user.setAddress(createUserDTO.getAddress());

    return userRepository.save(user);
}

  @Override
  public Long delete(Long id) {

    User user = new User();

    user.setId(id);

    userRepository.delete(user);

    return id;
  }

  @Override
  public User findById(Long id) {
    boolean present = userRepository.findById(id).isPresent();

    if (present) {
      return userRepository.findById(id).get();
    } else {
      return null;
    }
  }
}
