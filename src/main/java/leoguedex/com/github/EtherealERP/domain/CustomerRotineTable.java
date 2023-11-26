package leoguedex.com.github.EtherealERP.domain;

import jakarta.persistence.*;
import leoguedex.com.github.EtherealERP.domain.enums.QuantityPercentageEnum;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private TypeDaysEnum riceType;
    private Integer rice;
    private TypeDaysEnum potatoType;
    private Integer potato;
    private TypeDaysEnum pastaType;
    private Integer pasta;
    private TypeDaysEnum brownRiceType;
    private Integer brownRice;
    private TypeDaysEnum wholeWheatPastaType;
    private Integer wholeWheatPasta;
    private TypeDaysEnum quinoaType;
    private Integer quinoa;
    private TypeDaysEnum beansType;
    private Integer beans;
    private TypeDaysEnum lentilsType;
    private Integer lentils;
    private TypeDaysEnum chickpeasType;
    private Integer chickpeas;
    private TypeDaysEnum fishType;
    private Integer fish;
    private TypeDaysEnum redMeatType;
    private Integer redMeat;
    private TypeDaysEnum poultryType;
    private Integer poultry;
    private TypeDaysEnum eggsType;
    private Integer eggs;
    private TypeDaysEnum sweetPotatoType;
    private Integer sweetPotato;
    private TypeDaysEnum cassavaType;
    private Integer cassava;
    private TypeDaysEnum pumpkinType;
    private Integer pumpkin;
    private TypeDaysEnum yamType;
    private Integer yam;
    private TypeDaysEnum kaleType;
    private Integer kale;
    private TypeDaysEnum spinachType;
    private Integer spinach;
    private TypeDaysEnum arugulaType;
    private Integer arugula;
    private TypeDaysEnum lettuceType;
    private Integer lettuce;
    private TypeDaysEnum cauliflowerType;
    private Integer cauliflower;
    private TypeDaysEnum broccoliType;
    private Integer broccoli;
    private TypeDaysEnum zucchiniType;
    private Integer zucchini;
    private TypeDaysEnum soupsType;
    private Integer soups;
    private TypeDaysEnum saladsType;
    private Integer salads;
    private TypeDaysEnum nutsType;
    private Integer nuts;
    private TypeDaysEnum seedsType;
    private Integer seeds;
    private TypeDaysEnum fruitsType;
    private Integer fruits;
    private TypeDaysEnum flourType;
    private Integer flour;
    private TypeDaysEnum milkType;
    private Integer milk;
    private TypeDaysEnum yogurtType;
    private Integer yogurt;
    private TypeDaysEnum cheeseType;
    private Integer cheese;
    private TypeDaysEnum slicedBreadType;
    private Integer slicedBread;
    private TypeDaysEnum frenchBreadType;
    private Integer frenchBread;
    private TypeDaysEnum wholeWheatBreadType;
    private Integer wholeWheatBread;
    private TypeDaysEnum processedMeatsType;
    private Integer processedMeats;
    private TypeDaysEnum biscuitsType;
    private Integer biscuits;
    private TypeDaysEnum dessertType;
    private Integer dessert;
    private TypeDaysEnum sodaType;
    private Integer soda;
    private TypeDaysEnum boxedJuiceType;
    private Integer boxedJuice;
    private TypeDaysEnum frozenFoodsType;
    private Integer frozenFoods;
    private QuantityPercentageEnum organic;

}
