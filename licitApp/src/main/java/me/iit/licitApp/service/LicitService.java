package me.iit.licitApp.service;

import me.iit.licitApp.service.dto.Licit;

public interface LicitService {
    Licit saveNewLicit(Licit licit);
    Licit findMaximumLicitByUserNameAndItemName(String userName, String itemName);
}
