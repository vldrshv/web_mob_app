package com.bmstu.video.web

import com.bmstu.video.entity.User
import com.google.gson.Gson
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestAttribute
import org.springframework.web.bind.annotation.RequestMapping
import java.util.logging.Logger
import sun.plugin2.util.PojoUtil.toJson
import java.util.HashMap
import java.util.ArrayList



@Controller
@RequestMapping("/main")
class MainPageController {

    var logger: Logger = Logger.getAnonymousLogger()
    var currentUser: User? = null

    @GetMapping("/")
    fun mainPage(model: Model): String {

        val data: Map<String, String> = setData()
        logger.info("${data.keys}")
        logger.info(model.asMap()["user"].toString())

        model.addAttribute("dataPointsList", data)
        model.addAttribute("dataList", getChartPoints())
        logger.info("user_main_page")
        return "jsp/main_page"
    }

    private fun setData(): Map<String, String> {
        var map: HashMap<String, String> =  HashMap<String, String>()

        map.put("label", "2000")
        map.put("y", "43")

        return map
    }

    private fun getChartPoints() : String {
        val gsonObj = Gson()
        var map: MutableMap<Any, Any>? = null
        val list = ArrayList<Map<Any, Any>>()

        map = HashMap<Any, Any>()
        map !!.put("label", "2000")
        map!!.put("y", 43)
        list.add(map)
        map = HashMap<Any, Any>()
        map!!.put("label", "2001")
        map!!.put("y", 49)
        list.add(map)
        map = HashMap<Any, Any>()
        map!!.put("label", "2002")
        map!!.put("y", 59)
        list.add(map)
        map = HashMap<Any, Any>()
        map!!.put("label", "2003")
        map!!.put("y", 62)
        list.add(map)
        map = HashMap<Any, Any>()
        map!!.put("label", "2004")
        map!!.put("y", 65)
        list.add(map)
        map = HashMap<Any, Any>()
        map!!.put("label", "2005")
        map!!.put("y", 68)
        list.add(map)
        map = HashMap<Any, Any>()
        map!!.put("label", "2006")
        map!!.put("y", 69)
        list.add(map)
        map = HashMap<Any, Any>()
        map!!.put("label", "2007")
        map!!.put("y", 75)
        list.add(map)
        map = HashMap<Any, Any>()
        map!!.put("label", "2008")
        map!!.put("y", 74)
        list.add(map)
        map = HashMap<Any, Any>()
        map!!.put("label", "2009")
        map!!.put("y", 71)
        list.add(map)
        map = HashMap<Any, Any>()
        map!!.put("label", "2010")
        map!!.put("y", 72)
        list.add(map)
        map = HashMap<Any, Any>()
        map!!.put("label", "2011")
        map!!.put("y", 70)
        list.add(map)
        map = HashMap<Any, Any>()
        map!!.put("label", "2012")
        map!!.put("y", 75)
        list.add(map)
        map = HashMap<Any, Any>()
        map!!.put("label", "2013")
        map!!.put("y", 72)
        list.add(map)
        map = HashMap<Any, Any>()
        map!!.put("label", "2014")
        map!!.put("y", 73)
        list.add(map)
        map = HashMap<Any, Any>()
        map!!.put("label", "2015")
        map!!.put("y", 75)
        list.add(map)

        return gsonObj.toJson(list)
    }

}