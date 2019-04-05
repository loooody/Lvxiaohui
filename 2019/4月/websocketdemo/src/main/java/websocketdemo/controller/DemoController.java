package websocketdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: WebSocketController
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-4-4 下午3:44
 * @Version 1.0
 **/

@Controller
public class DemoController {

    @RequestMapping("/index")
    public String hello(){

        return "index";
    }
}
