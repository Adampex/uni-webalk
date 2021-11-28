package me.iit.licitApp.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.iit.licitApp.service.dto.Licit;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateLicitDto {

    @NotEmpty
    private String itemName;

    @NotEmpty
    private String userName;

    @NotNull
    @Min(10)
    private int licitMoney;

    public Licit toLicit() {
        return new Licit(null, itemName, userName, licitMoney);
    }
}
