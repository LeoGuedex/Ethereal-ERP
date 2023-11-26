package leoguedex.com.github.EtherealERP.repository;

import leoguedex.com.github.EtherealERP.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
