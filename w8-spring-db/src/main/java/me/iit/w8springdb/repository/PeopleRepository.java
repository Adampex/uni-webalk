package me.iit.w8springdb.repository;

import me.iit.w8springdb.service.People;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PeopleRepository extends PagingAndSortingRepository<PeopleModal, Long> {
}
