package me.iit.licitApp.service;

import me.iit.licitApp.repository.LicitRepository;
import me.iit.licitApp.service.dto.Licit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LicitServiceImpl implements LicitService {

    private final LicitRepository licitRepository;

    public LicitServiceImpl(LicitRepository licitRepository) {
        this.licitRepository = licitRepository;
    }

    public Licit saveNewLicit(Licit licit) {
        List<Licit> licitList = new ArrayList<>();
        for (me.iit.licitApp.entity.Licit entity : licitRepository.findLicitByUserNameAndItemName(licit.getUserName(), licit.getItemName())) {
            licitList.add(new Licit(entity));
        }

        if (licitList.isEmpty()) {
            return new Licit(licitRepository.save(licit.toEntity()));
        }

        Licit highestLicit = new Licit();

        for (int i = 0; i < licitList.size(); i++) {
            if (licitList.get(i).getLicitMoney() < licit.getLicitMoney()) {
                highestLicit = licit;
            } else {
                highestLicit = licitList.get(i);
            }
        }

        if (!licitList.contains(highestLicit)) {
            return new Licit(licitRepository.save(highestLicit.toEntity()));
        }

        return null;
    }

    @Override
    public Licit findMaximumLicitByUserNameAndItemName(String userName, String itemName) {
        return new Licit(licitRepository.findFirstByUserNameAndItemNameOrderByLicitMoneyDesc(userName, itemName));
    }
}
