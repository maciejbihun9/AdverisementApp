package mySqlrepository;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Maciek on 2016-11-16.
 */
public interface UserRepository extends JpaRepository <User, Long> {
}
