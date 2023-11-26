package leoguedex.com.github.EtherealERP.repository;

import leoguedex.com.github.EtherealERP.domain.CustomerRotineTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRotineTableRepository extends JpaRepository<CustomerRotineTable, Long> {

}
