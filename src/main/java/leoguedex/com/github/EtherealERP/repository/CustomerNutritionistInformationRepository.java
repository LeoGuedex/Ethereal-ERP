package leoguedex.com.github.EtherealERP.repository;

import leoguedex.com.github.EtherealERP.domain.CustomerNutritionistInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerNutritionistInformationRepository extends
        JpaRepository<CustomerNutritionistInformation, Long> {

}
