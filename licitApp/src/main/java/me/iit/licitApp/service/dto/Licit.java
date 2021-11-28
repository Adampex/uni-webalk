package me.iit.licitApp.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Optional;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Licit {

    private UUID licitId;

    private String itemName;

    private String userName;

    private int licitMoney;

    public Licit(Optional<me.iit.licitApp.entity.Licit> licitEntity) {
        this.licitId = licitEntity.get().getLicitId();
        this.itemName = licitEntity.get().getItemName();
        this.userName = licitEntity.get().getUserName();
        this.licitMoney = licitEntity.get().getLicitMoney();
    }

    public me.iit.licitApp.entity.Licit toEntity() {
        return new me.iit.licitApp.entity.Licit(licitId, itemName, userName, licitMoney);
    }

    public Licit(me.iit.licitApp.entity.Licit licitEntity) {
        this.licitId = licitEntity.getLicitId();
        this.itemName = licitEntity.getItemName();
        this.userName = licitEntity.getUserName();
        this.licitMoney = licitEntity.getLicitMoney();
    }
}
