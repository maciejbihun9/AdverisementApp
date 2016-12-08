package service;

import model.User;
import model.UserWord;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserWordService {

    List<UserWord> getUserWordsByInput(long userId);

    void combineUserWordWithAdvertiserPage(long userId);

}
