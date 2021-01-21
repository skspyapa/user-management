package lk.rumex.user.management.service.impl;

import lk.rumex.user.management.Repository.UserRepository;
import lk.rumex.user.management.dto.CreateUserDTO;
import lk.rumex.user.management.exception.UserNotFoundException;
import lk.rumex.user.management.model.User;
import lk.rumex.user.management.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

  /**
   *find all users method
   */
  @Override
  public List<User> findAll() {
    logger.info("Find All users");
    return userRepository.findAll();
  }

  /**
   *create user method
   */
  @Override
  public User create(CreateUserDTO createUserDTO) {
    User user = new User();
    user.setAge(createUserDTO.getAge());
    user.setAddress(createUserDTO.getAddress());
    User savedUser = userRepository.save(user);
    logger.info("User created");
    return savedUser;
}

  /**
   *delete user method
   */
  @Override
  public Long delete(Long id) {
    User user = new User();
    user.setId(id);
    userRepository.delete(user);
    logger.info("User deleted");
    return id;
  }

  /**
   *find user by id method
   */
  @Override
  public User findById(Long id) throws UserNotFoundException {
    boolean present = userRepository.findById(id).isPresent();
    logger.error("Find user by id");
    if (present) {
      return userRepository.findById(id).get();
    } else {
      logger.error("No user for id [{}]", id);
      throw new UserNotFoundException("No user found user id [{"+ id +"}]");
    }
  }
}
