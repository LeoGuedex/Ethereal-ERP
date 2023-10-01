package leoguedex.com.github.HealthCoachWeb.repository;

import leoguedex.com.github.HealthCoachWeb.domain.CustomerGym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerGymRepository extends JpaRepository<CustomerGym, Long> {

}
