package jpabook.merchandiseManagement.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ServerWebExchange;

import java.util.Map;

@Controller
@Slf4j
public class HomeController {
    //
//    @RequestMapping
//    public String home() {
//        log.info("login controller");
////        return "login";
//        return "home";
//    }
//
    @GetMapping("/login")
    public String login(){
        log.info("home controller");
        return "/login/login";
    }
//    @RequestMapping("/")
//    public String home() {
//        log.info("home controller");
//        return "home";
//    }


    @RequestMapping("/")
    public String loginHome() {
        log.info("login controller");
        return "home";
    }

    @RequestMapping("/home")
    public String home() {
        log.info("home controller");
        return "home";
    }

    @GetMapping("/login/admin")
    public String adminPage(@AuthenticationPrincipal User user,
                            Map<String, Object> model) {
        model.put("currentAdminId", user.getUsername());
        return "login/adminpage";
    }
}
