package leoguedex.com.github.HealthCoachWeb.repository;

import leoguedex.com.github.HealthCoachWeb.domain.CustomerHealth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerHealthRepository extends JpaRepository<CustomerHealth, Long> {

}
