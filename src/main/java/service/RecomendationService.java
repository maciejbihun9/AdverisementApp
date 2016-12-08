package service;

import model.Recomendation;
import org.springframework.stereotype.Service;

/**
 * Created by Maciek on 2016-12-01.
 */
@Service
public interface RecomendationService {

    Recomendation createRecomendationsForUser(long userId);

}
