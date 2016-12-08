package controller;

/**
 * Created by Maciek on 2016-11-23.
 */

import mySqlrepository.UserPageValueRepository;
import model.AdvertiserPage;
import model.UserPageValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import service.AdvertiserService;
import util.page_parser_utils.PageParserEnvironment;

import java.util.List;

@RestController
@RequestMapping(value = "/ads")
@Transactional
public class AdvertisementRestController {

    /*@Autowired
    AdvertiserPageRepository advertiserPageRepository;*/

    @Autowired
    AdvertiserService advertiserService;

    @Autowired
    PageParserEnvironment pageParserEnvironment;

    @Autowired
    UserPageValueRepository userPageValueRepository;

    @RequestMapping(
            value = "/storePage",
            method= RequestMethod.POST,
            produces = "application/json")
    public AdvertiserPage storePage(@RequestBody AdvertiserPage advertiserPage){
        advertiserService.saveAdvertiserPageDetails(advertiserPage);
        return advertiserPage;
    }

    @RequestMapping(value = "/getAllAds", produces = "application/json")
    public List<AdvertiserPage> getAllAds(){
        return advertiserService.getAllAdvertiserPages();
    }

    @RequestMapping(
            value = "/storeAdClick",
            method= RequestMethod.POST,
            consumes = "application/json"
    )
    public void saveAdClick(@RequestBody String pageIdString){
        long pageId = Long.parseLong(pageIdString);
        AdvertiserPage clickedAd = advertiserService.getAdvertiserPageById(pageId);
        UserPageValue userPageValue = new UserPageValue();
        userPageValue.setClicks(userPageValue.getClicks() + 1);
    }

    @RequestMapping(
            value = "/ad/{id}",
            method= RequestMethod.GET,
            produces = "application/json")
    public AdvertiserPage getCommercialById(@PathVariable(value = "id") Long id){
        return advertiserService.getAdvertiserPageById(id);
    }

}
