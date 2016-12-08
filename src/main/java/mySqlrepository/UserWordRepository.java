package mySqlrepository;

import model.UserWord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Maciek on 2016-11-19.
 */
public interface UserWordRepository extends JpaRepository<UserWord, Long> {
}
