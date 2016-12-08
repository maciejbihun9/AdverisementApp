package service;

import model.UserInput;
import org.springframework.stereotype.Service;

@Service
public interface UserInputService {

    UserInput saveUserInput(UserInput userInput);

    UserInput getUserInputById(long userInputId);

}
