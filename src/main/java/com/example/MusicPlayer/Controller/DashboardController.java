package com.example.MusicPlayer.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/")
    public String Dashboard (){
    return "Dashboard";
    }

}
