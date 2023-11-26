package leoguedex.com.github.EtherealERP.repository;

import leoguedex.com.github.EtherealERP.domain.CustomerGym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerGymRepository extends JpaRepository<CustomerGym, Long> {

}
