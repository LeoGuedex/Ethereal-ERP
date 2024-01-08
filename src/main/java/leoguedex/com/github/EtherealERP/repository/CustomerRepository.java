package leoguedex.com.github.EtherealERP.repository;

import leoguedex.com.github.EtherealERP.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c order by c.whenCreated desc limit 6")
    List<Customer> selectNewlyRegistered();

}