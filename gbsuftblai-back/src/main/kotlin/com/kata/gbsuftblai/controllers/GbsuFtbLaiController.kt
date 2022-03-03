package com.kata.gbsuftblai.controllers

import com.kata.gbsuftblai.services.GbsuFtbLaiService
import com.kata.gbsuftblai.views.ResultDto
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/gbsu-ftb-lai")
class GbsuFtbLaiController(private val gbsuFtbLaiService: GbsuFtbLaiService) {

    @GetMapping("/{inputNumber}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun convertNumber(@PathVariable(name = "inputNumber") inputNumber: Int): ResultDto {
        return ResultDto(gbsuFtbLaiService.convertNumber(inputNumber))
    }

}
