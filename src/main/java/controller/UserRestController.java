package controller;

import mySqlrepository.UserWordRepository;
import mySqlrepository.UserInputRepository;
import model.User;
import model.UserInput;
import model.UserWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import service.UserInputService;
import service.UserPageValueService;
import service.UserService;
import util.WordValidator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Maciek on 2016-11-19.
 */
@RestController
@RequestMapping(value= "/user")
@Transactional
public class UserRestController {

    @Autowired
    UserWordRepository userWordRepository;

    @Autowired
    UserInputRepository userInputRepository;

    @Autowired
    UserInputService userInputService;

    @Autowired
    UserService userService;

    @Autowired
    UserPageValueService userPageValueService;

    @RequestMapping(
            value = "/saveUser",
            method= RequestMethod.POST,
            consumes="application/json")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    /*@RequestMapping(value = "/users", produces = "application/json")
    public List<User> getAllUsers(){
        return userService.f();
    }*/

    @RequestMapping(
            value = "/words",
            method= RequestMethod.GET,
            produces = "application/json")
    public List<UserWord> getUserWords(){
        return userWordRepository.findAll();
    }

    @RequestMapping(
            value = "/processUserInput",
            method= RequestMethod.POST,
            consumes="application/json")
    public UserInput processUserInput(@RequestBody UserInput userInput){

        long userId = 1L;
        User userById = userService.getUserById(userId);
        userInput.setUserId(userById);

        String[] wordsFromText = WordValidator.getWordsFromText(userInput.getUserInputValue());

        //get words hashCode
        List<Integer> wordHashCodes = new ArrayList<Integer>();
        for(String word : wordsFromText){
            wordHashCodes.add(word.hashCode());
        }
        List<UserWord> validatedUserWords = new ArrayList<>();
        List<Integer> validatedWordHashCodes = WordValidator.removeStopWords(wordHashCodes);
        for(String userWord : wordsFromText){
            if(validatedWordHashCodes.contains(userWord.hashCode())){
                UserWord word = new UserWord();
                word.setUserId(userId);
                word.setWordName(userWord);
                word.setLastUsedDate(new Date().toString());
                word.setUserInputId(userInput);
                userInput.getValidatedInputWords().add(word);
                validatedUserWords.add(word);
            }
        }
        userInput.getValidatedInputWords().addAll(validatedUserWords);
        userById.getUserInputs().add(userInput);
        userService.saveUser(userById);

        //bind user with advertiser page
        //userPageValueService.createUserPageValue(userInput);
        userPageValueService.createUserPageValue(userInput);

        return userInput;
    }

    /**********************************************
     * USER  UserInputRepository METHODS
     *********************************************/

    @RequestMapping(
            value = "/getAllUsersInputs",
            method= RequestMethod.GET,
            produces = "application/json")
    public List<UserInput> getUserInputs(){
        return userInputRepository.findAll();
    }


}
