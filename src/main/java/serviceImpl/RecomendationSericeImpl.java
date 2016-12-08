package serviceImpl;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AdvertiserService;
import service.RecomendationService;
import service.UserService;

import java.util.List;

@Service
public class RecomendationSericeImpl implements RecomendationService {

    @Autowired
    AdvertiserService advertiserService;

    @Autowired
    UserService userService;

    @Override
    public Recomendation createRecomendationsForUser(long userId) {

        Recomendation recomendation = createRecomendation();

        return null;

    }



    private Recomendation createRecomendation(){
        return null;
    }

}
