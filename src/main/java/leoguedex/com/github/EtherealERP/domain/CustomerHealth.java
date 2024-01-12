package leoguedex.com.github.EtherealERP.domain;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import leoguedex.com.github.EtherealERP.domain.enums.DiseasesEnum;
import leoguedex.com.github.EtherealERP.domain.enums.QuantityPercentageEnum;
import leoguedex.com.github.EtherealERP.domain.enums.SleepTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerHealth {

    @Id
    private Long id;

    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ElementCollection(targetClass = DiseasesEnum.class)
    @CollectionTable(name = "Diseases", joinColumns = @JoinColumn(name = "customer_id"))
    @Enumerated(EnumType.STRING)
    private Set<DiseasesEnum> diseases;

    private String weekdaySleepHours;
    private String weekendSleepHours;
    private String moodDescription;
    private String healthDescription;
    private SleepTypeEnum sleepTypeEnum;
    private String energyReductionMethods;
    private String stressReductionMethods;
    private String sleepImprovementMethods;
    private QuantityPercentageEnum stressLevel;
    private QuantityPercentageEnum recentMemory;
    private QuantityPercentageEnum concentration;
    private QuantityPercentageEnum daytimeEnergy;
    private QuantityPercentageEnum longTermMemory;
    private QuantityPercentageEnum morningDisposition;
    private QuantityPercentageEnum eveningDisposition;
    private QuantityPercentageEnum afternoonDisposition;

}
