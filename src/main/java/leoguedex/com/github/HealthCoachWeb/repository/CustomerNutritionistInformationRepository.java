package leoguedex.com.github.HealthCoachWeb.repository;

import leoguedex.com.github.HealthCoachWeb.domain.CustomerNutritionistInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerNutritionistInformationRepository extends
    JpaRepository<CustomerNutritionistInformation, Long> {

}
