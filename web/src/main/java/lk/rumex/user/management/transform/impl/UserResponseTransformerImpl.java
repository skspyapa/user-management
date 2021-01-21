package lk.rumex.user.management.transform.impl;

import lk.rumex.user.management.model.User;
import lk.rumex.user.management.transform.UserResponseTransformer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserResponseTransformerImpl implements UserResponseTransformer {


  private static User transformUsers(User singleUser) {
    User user = new User();
    user.setId(singleUser.getId());
    user.setAddress(singleUser.getAddress());
    return user;
  }

  @Override
  public List<User> findAllUsersTransformer(List<User> users) {
    return users.stream().map(UserResponseTransformerImpl::transformUsers).collect(Collectors.toList());
  }
}
