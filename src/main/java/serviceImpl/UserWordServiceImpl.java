package serviceImpl;

import model.UserWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserInputService;
import service.UserService;
import service.UserWordService;

import java.util.List;

@Service
public class UserWordServiceImpl implements UserWordService {

    @Autowired
    UserService userService;

    @Autowired
    UserInputService userInputService;

    @Override
    public List<UserWord> getUserWordsByInput(long userId) {
        return null;
    }

    @Override
    public void combineUserWordWithAdvertiserPage(long userId) {

    }
}
