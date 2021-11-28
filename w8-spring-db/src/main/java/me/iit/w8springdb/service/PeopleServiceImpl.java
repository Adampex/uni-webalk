package me.iit.w8springdb.service;

import me.iit.w8springdb.exception.NoSuchEntity;
import me.iit.w8springdb.repository.PeopleModal;
import me.iit.w8springdb.repository.PeopleRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PeopleServiceImpl implements PeopleService {

    private final PeopleRepository peopleRepository;

    public PeopleServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public Iterable<People> getAllPeople() {
        //return peopleRepository.findAll();
        return StreamSupport.stream(peopleRepository.findAll().spliterator(), false)
                .map(People::new).collect(Collectors.toList());
    }

    @Override
    public People create(People people) {
        return new People(peopleRepository.save(people.toEntity()));
    }

    @Override
    public void deleteById(Long id) {
        try {
            peopleRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new NoSuchEntity(id);
        }
    }

    public Iterable<People> getAllPeopleTwo() {
        List<People> rv = new ArrayList<>();

        for (PeopleModal people : peopleRepository.findAll()) {
            rv.add(new People(people));
        }
        return rv;
    }

    @Override
    public People getById(Long id) {
        Optional<PeopleModal> peopleModal = peopleRepository.findById(id);

        if (peopleModal.isEmpty()) {
            throw new NoSuchEntity(id);
        }
        return new People(peopleModal.get());
    }

    @Override
    public void save(People people) {
        Optional<PeopleModal> peopleModal = peopleRepository.findById(people.getId());

        if (peopleModal.isEmpty()) {
            throw new NoSuchEntity(people.getId());
        }
        peopleRepository.save(people.toEntity());
    }

    @Override
    public Iterable<? extends People> findByAgeGreaterThan(int age) {
        return StreamSupport.stream(peopleRepository.findAllByAgeGreaterThanEqual(age).spliterator(), false)
                .map(People:: new)
                .collect(Collectors.toList());
    }
}
