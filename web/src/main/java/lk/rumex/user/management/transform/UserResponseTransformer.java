package lk.rumex.user.management.transform;

import com.fasterxml.jackson.core.JsonProcessingException;
import lk.rumex.user.management.model.User;

import java.util.List;

public interface UserResponseTransformer {
      List<User> findAllUsersTransformer(List<User> users) throws JsonProcessingException;
}
