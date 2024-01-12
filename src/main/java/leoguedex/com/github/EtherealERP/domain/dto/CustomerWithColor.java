package leoguedex.com.github.EtherealERP.domain.dto;

import leoguedex.com.github.EtherealERP.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerWithColor extends Customer {

    private String color;

}
