/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wajid.portfolio.controller;

/**
 *
 * @author Admin
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String sayHello() {
        return "index";
    }
    
    @RequestMapping("/loan")
    public String loan() {
        return "loan";
    }
}
