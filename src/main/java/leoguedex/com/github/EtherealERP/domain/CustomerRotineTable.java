package leoguedex.com.github.EtherealERP.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import leoguedex.com.github.EtherealERP.domain.enums.TypeDaysEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRotineTable {

    @Id
    private Long id;

    @MapsId
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private TypeDaysEnum rice;
    private TypeDaysEnum potato;
    private TypeDaysEnum pasta;
    private TypeDaysEnum brownRice;
    private TypeDaysEnum wholeWheatPasta;
    private TypeDaysEnum quinoa;
    private TypeDaysEnum beans;
    private TypeDaysEnum lentils;
    private TypeDaysEnum chickpeas;
    private TypeDaysEnum fish;
    private TypeDaysEnum redMeat;
    private TypeDaysEnum poultry;
    private TypeDaysEnum eggs;
    private TypeDaysEnum sweetPotato;
    private TypeDaysEnum cassava;
    private TypeDaysEnum pumpkin;
    private TypeDaysEnum yam;
    private TypeDaysEnum kale;
    private TypeDaysEnum spinach;
    private TypeDaysEnum arugula;
    private TypeDaysEnum lettuce;
    private TypeDaysEnum cauliflower;
    private TypeDaysEnum broccoli;
    private TypeDaysEnum zucchini;
    private TypeDaysEnum soups;
    private TypeDaysEnum salads;
    private TypeDaysEnum nuts;
    private TypeDaysEnum seeds;
    private TypeDaysEnum fruits;
    private TypeDaysEnum flour;
    private TypeDaysEnum milk;
    private TypeDaysEnum yogurt;
    private TypeDaysEnum cheese;
    private TypeDaysEnum slicedBread;
    private TypeDaysEnum frenchBread;
    private TypeDaysEnum wholeWheatBread;
    private TypeDaysEnum processedMeats;
    private TypeDaysEnum biscuits;
    private TypeDaysEnum dessert;
    private TypeDaysEnum soda;
    private TypeDaysEnum boxedJuice;
    private TypeDaysEnum frozenFoods;

}
