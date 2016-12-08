package mySqlrepository;

import model.UserInput;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Maciek on 2016-11-26.
 */
public interface UserInputRepository extends JpaRepository<UserInput, Long> {
}
