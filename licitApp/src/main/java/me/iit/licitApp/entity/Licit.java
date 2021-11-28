package me.iit.licitApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Licit {

    @Id
    @GeneratedValue
    private UUID licitId;

    private String itemName;

    private String userName;

    private int licitMoney;
}
