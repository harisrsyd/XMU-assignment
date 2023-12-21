package com.assignment.crudperpustakaan.frontcontrol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardControl {

    @GetMapping("/")
    public String landingPage(){
        return "/landingpage/landingpage";
    }

    @GetMapping("/manage")
    public String manageBooks(){
        return "/manage/booksmanager";
    }

    @GetMapping("/add")
    public String addBooks(){
        return "/manage/addbook";
    }

    @GetMapping("/edit")
    public String editBooks(){
        return "/manage/editbook";
    }

    @GetMapping("/delete")
    public String deleteBooks(){
        return "/manage/deletebook";
    }

}
