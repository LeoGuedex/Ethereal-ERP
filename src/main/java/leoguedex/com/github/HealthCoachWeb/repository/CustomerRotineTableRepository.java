package leoguedex.com.github.HealthCoachWeb.repository;

import leoguedex.com.github.HealthCoachWeb.domain.CustomerRotineTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRotineTableRepository extends JpaRepository<CustomerRotineTable, Long> {

}
