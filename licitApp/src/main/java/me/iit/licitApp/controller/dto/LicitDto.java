package me.iit.licitApp.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.iit.licitApp.service.dto.Licit;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LicitDto {

    private UUID licitId;

    private String itemName;

    private String userName;

    private int licitMoney;

    public Licit toServiceDto() {
        return new Licit(licitId, itemName, userName, licitMoney);
    }

    public LicitDto(Licit licit) {
        this.licitId = licit.getLicitId();
        this.itemName = licit.getItemName();
        this.userName = licit.getUserName();
        this.licitMoney = licit.getLicitMoney();
    }
}
