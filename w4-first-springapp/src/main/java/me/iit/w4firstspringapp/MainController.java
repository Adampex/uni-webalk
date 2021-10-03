package me.iit.w4firstspringapp;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(path="/", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseDto gyoker() {
        ResponseDto responseDto = new ResponseDto();

        responseDto.setId(123);
        responseDto.setMessage("Hello");
        return responseDto;
    }
}