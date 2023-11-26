package leoguedex.com.github.EtherealERP.repository;

import leoguedex.com.github.EtherealERP.domain.CustomerHealth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerHealthRepository extends JpaRepository<CustomerHealth, Long> {

}
