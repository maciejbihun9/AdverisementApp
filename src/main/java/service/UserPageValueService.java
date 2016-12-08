package service;

import model.User;
import model.UserInput;
import model.UserPageValue;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface UserPageValueService {

     void createUserPageValue(UserInput userInput);

     UserPageValue findByPageIdAndUserId(long pageId, long userId);

}
