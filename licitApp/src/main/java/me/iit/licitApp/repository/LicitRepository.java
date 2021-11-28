package me.iit.licitApp.repository;

import me.iit.licitApp.entity.Licit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LicitRepository extends JpaRepository<Licit, UUID> {
    List<Licit> findLicitByUserNameAndItemName(String userName, String itemName);
    Optional<Licit> findFirstByUserNameAndItemNameOrderByLicitMoneyDesc(String userName, String itemName);
}
