package com.bmstu.video.web

import java.util.logging.Logger
import com.bmstu.video.entity.User

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.util.MultiValueMap
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestMapping




@Controller
class ApplicationController {
    var logger: Logger = Logger.getAnonymousLogger()

    @GetMapping("/newUser")
    fun newUser(model: Model): String {
        model.addAttribute("user", User())
        model.addAttribute("isRegistered", false)
        logger.info("new user")
        return "newUser"
    }

    @RequestMapping("/")
    fun auth(model: Model): String {
        logger.info("authentication")
        //model.addAttribute("user", User())

        return "auth"
    }

    @PostMapping("/submit")
    fun submit(@ModelAttribute user: User, model: Model): String {
        logger.info("submit")
        logger.info("" + user.name)
        model.addAttribute("isRegistered", true)
        return "auth"
    }

    @RequestMapping("/user")
    fun validateUser(model: Model): String {
        logger.info("validate")
        model.addAttribute("user", User())

        return "auth"
    }

}