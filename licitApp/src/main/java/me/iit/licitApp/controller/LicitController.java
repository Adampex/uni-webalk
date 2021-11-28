package me.iit.licitApp.controller;

import me.iit.licitApp.controller.dto.CreateLicitDto;
import me.iit.licitApp.controller.dto.LicitDto;
import me.iit.licitApp.service.LicitService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class LicitController {

    private final LicitService licitService;

    public LicitController(LicitService licitService) {
        this.licitService = licitService;
    }

    @PostMapping(path="/newLicit", produces = MediaType.APPLICATION_JSON_VALUE)
    public LicitDto saveNewlicit(@RequestBody @Valid CreateLicitDto createLicitDto) {
        return new LicitDto(licitService.saveNewLicit(createLicitDto.toLicit()));
    }

    @GetMapping("/findMaximum/{userName}/{itemName}")
    public LicitDto findMaximumLicitByUserNameAndItemName(@PathVariable String userName, @PathVariable String itemName) {
        return new LicitDto(licitService.findMaximumLicitByUserNameAndItemName(userName, itemName));
    }
}
