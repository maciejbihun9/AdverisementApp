package serviceImpl;

import h2repository.AdvertiserPageRepository;
import model.*;
import model.modelDTO.AdvertiserPageDTO;
import model.modelDTO.PageKeyWordDTO;
import model.modelTranslator.AvertiserPageTranslator;
import mySqlrepository.UserPageValueRepository;
import mySqlrepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service.AdvertiserService;
import service.UserPageValueService;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserPageValueServiceImpl implements UserPageValueService {

    @Autowired
    AdvertiserService advertiserService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserPageValueRepository userPageValueRepository;

    @Autowired
    AvertiserPageTranslator advertiserPageTranslator;

    @Autowired
    AdvertiserPageRepository advertiserPageRepository;

    @Override
    public void createUserPageValue(UserInput userInput) {
        //get all advertiser pages
        //List<AdvertiserPage> allAdvertiserPages = advertiserService.getAllAdvertiserPages();
        List<AdvertiserPage> advertiserPages = advertiserPageRepository.findAll();

        //get all user input words
        List<UserWord> validatedInputWords = userInput.getValidatedInputWords();

        if(validatedInputWords.size() == 0){
            return;
        }

        //check how much words match userInput words with advertiser key words
        for(AdvertiserPage advertiserPage : advertiserPages){
            System.out.println("Advertiser page params : " + advertiserPage.getPageId() + " page name : "
                    + advertiserPage.getPageName());
            //List<PageKeyWord> pageKeyWords = advertiserPage.getPageKeyWords();
            List<PageKeyWord> advertiserPageKeyWords = getAdvertiserPageKeyWords(advertiserPage);
            long numberOfMatchedWords = comparedWords(validatedInputWords, advertiserPageKeyWords);
            if(numberOfMatchedWords > 0){
                //check if that ad is already attached to that user
                User userInputOwner = userInput.getUserId();
                if (userInputOwner.getAdvertiserPages().contains(advertiserPage)){
                    //if that owner already contain that advertiser page then update details if needed
                    UserPageValue ownerUserPageValue = findByPageIdAndUserId(advertiserPage.getPageId(), userInputOwner.getUserId());
                    if(numberOfMatchedWords > ownerUserPageValue.getNumberOfWordsMatched()){
                        //set new value and save
                        ownerUserPageValue.setNumberOfWordsMatched(numberOfMatchedWords);
                        userPageValueRepository.save(ownerUserPageValue);
                    }
                } else {
                    //create new userPageValue
                    UserPageValue userPageValue = new UserPageValue();
                    userPageValue.setNumberOfWordsMatched(numberOfMatchedWords);

                    userInputOwner.getAdvertiserPages().add(advertiserPage);
                    userRepository.save(userInputOwner);

                    advertiserPage.getUsers().add(userInputOwner);
                    advertiserPageRepository.save(advertiserPage);

                    userPageValue.setUserId(userInputOwner);
                    userPageValue.setOwningPage(advertiserPage);
                    userPageValueRepository.save(userPageValue);
                }
            }
        }
    }


    private List<PageKeyWord> getAdvertiserPageKeyWords(AdvertiserPage advertiserPage){
        return advertiserPage.getPageKeyWords();
    }

    @Override
    public UserPageValue findByPageIdAndUserId(long pageId, long userId) {
        return userPageValueRepository.findByPageIdAndUserId(pageId, userId);
    }


    private int comparedWords(List<UserWord> inputWords, List<PageKeyWord> keyWords){
        int counter = 0;
        for(UserWord userWord : inputWords){
            for (PageKeyWord keyWord : keyWords){
                if(userWord.getWordName().equalsIgnoreCase(keyWord.getPageKeyWord()))
                    counter++;
            }

        }
        return counter;
    }

}
