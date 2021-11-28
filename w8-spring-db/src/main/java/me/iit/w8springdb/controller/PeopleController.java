package me.iit.w8springdb.controller;

import me.iit.w8springdb.service.People;
import me.iit.w8springdb.service.PeopleService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public Iterable<PeopleDTO> getAllPeople() {
        List<PeopleDTO> peopleDTOList = new ArrayList<>();

        for (People people:peopleService.getAllPeople()) {
            peopleDTOList.add(new PeopleDTO(people));
        }
        return peopleDTOList;
    }

    @PostMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public PeopleDTO save(@RequestBody @Valid PeopleCreateDto peopleCreateDto) {
        return new PeopleDTO(peopleService.create(peopleCreateDto.toPeople()));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        peopleService.deleteById(id);
    }

    @PutMapping
    public void updatePeople(@RequestBody @Valid PeopleDTO peopleDTO) {
        peopleService.save(peopleDTO.toEntity());
    }

    @GetMapping("/{id}")
    public PeopleDTO getById(@PathVariable("id") Long id) {
        return new PeopleDTO(peopleService.getById(id));
    }

    @GetMapping("/findByAgeGt")
    Iterable<PeopleDTO> findAdultPeople(@RequestParam("age") int age) {
        List<me.iit.w8springdb.controller.PeopleDTO> peopleDTOList = new ArrayList<>();
        for (People people : peopleService.findByAgeGreaterThan(age)) {
            peopleDTOList.add(new me.iit.w8springdb.controller.PeopleDTO(people));
        }
        return peopleDTOList;
    }
}
