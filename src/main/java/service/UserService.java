package service;

import model.User;
import org.springframework.stereotype.Service;

/**
 * Created by Maciek on 2016-12-01.
 */
@Service
public interface UserService {

    User saveUser(User user);

    User getUserById(long id);

}
