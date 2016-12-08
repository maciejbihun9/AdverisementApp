package serviceImpl;

import mySqlrepository.UserInputRepository;
import model.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserInputService;

@Service
public class UserInputServiceImpl implements UserInputService{

    @Autowired
    UserInputRepository userInputRepository;

    @Override
    public UserInput saveUserInput(UserInput userInput) {
        return userInputRepository.save(userInput);
    }

    @Override
    public UserInput getUserInputById(long userInputId) {
        return null;
    }
}
