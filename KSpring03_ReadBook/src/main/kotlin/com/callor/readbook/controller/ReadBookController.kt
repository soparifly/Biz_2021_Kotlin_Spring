package com.callor.readbook.controller

import com.callor.readbook.config.logger
import com.callor.readbook.model.ReadBookVO
import com.callor.readbook.service.ReadBookService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody


@Controller
class ReadBookController(val readBookService: ReadBookService) {

    @RequestMapping(value=["/",""],method=[RequestMethod.GET])
    fun home(model:Model) : String {
        model["BOOKLIST"] =  readBookService.readBookSelectAll()

        return "readbook/list"
    }

    @RequestMapping(value = ["/insert"],method = [RequestMethod.GET])
    fun insert(): String{
        return "readbook/write"
    }

    @RequestMapping(value = ["/insert"],method = [RequestMethod.POST])
    fun insert(readBook: ReadBookVO) :String{
        logger().debug(""">
            수신한 데이터 {} """,readBook.toString())

        readBookService.readBookInsert(readBook)

        return "redirect:/insert"
    }
}