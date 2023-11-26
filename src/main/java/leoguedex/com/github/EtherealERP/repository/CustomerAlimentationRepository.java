package leoguedex.com.github.EtherealERP.repository;

import leoguedex.com.github.EtherealERP.domain.CustomerAlimentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAlimentationRepository extends JpaRepository<CustomerAlimentation, Long> {

}
