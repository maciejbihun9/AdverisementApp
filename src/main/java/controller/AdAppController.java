package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Maciek on 2016-11-12.
 */

@Controller
public class AdAppController {

    @RequestMapping("/main")
    private String getMainRouterView() {
        return "main";
    }
}
