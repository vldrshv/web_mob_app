package com.bmstu.video.web

import java.util.logging.Logger
import com.bmstu.video.entity.User
import com.bmstu.video.entity.UserAPI
import com.bmstu.video.entity.UserInfo
import com.bmstu.video.entity.UserService

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.util.MultiValueMap
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.GetMapping

@Controller
@RequestMapping("/")
class ApplicationController {
    var logger: Logger = Logger.getAnonymousLogger()
    var currentUser: User? = null

    @GetMapping("/newUser")
    fun newUser(model: Model): String {
        model.addAttribute("user", User())
        model.addAttribute("isRegistered", false)
        logger.info("new user")
        return "thymeleaf/newUser"
    }

    @RequestMapping("/")
    fun auth(model: Model): String {
        logger.info("authentication")
        model.addAttribute("user", User())

        return "thymeleaf/auth"
    }

    @PostMapping("/submit")
    fun submit(@ModelAttribute user: User, model: Model): String {
        logger.info("submit")
        logger.info("" + user.name)
        model.addAttribute("isRegistered", true)
        return "thymeleaf/auth"
    }

    @RequestMapping("/user")
    fun validateUser(@ModelAttribute user: User, model: Model): String {
        logger.info("validate")

        val userApi: UserAPI = UserAPI()
        val service: UserService = userApi.initServices()
        var userInfo: UserInfo? = service.getUser(user.email!!).execute().body()

        logger.info(userInfo.toString())
        if (validate(user, userInfo!!.user)) {
            model.addAttribute("user", userInfo!!.user)
            model.addAttribute("user", userInfo.user)
            return "redirect:/main/"
        }

        return "thymeleaf/auth"
    }

    private fun validate(userInput: User, userServer: User): Boolean {
        return userInput.email.equals(userServer.email) && userInput.pin.equals(userServer.pin)
    }

    @RequestMapping("/main_page")
    fun mainPage(@ModelAttribute user: User, model: Model): String {
        logger.info("main_page")

        model.addAttribute("user", currentUser)
        logger.info(currentUser.toString())
        return "thymeleaf/main_page"
    }
}