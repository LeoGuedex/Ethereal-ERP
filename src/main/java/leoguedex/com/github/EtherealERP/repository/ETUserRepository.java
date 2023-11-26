package leoguedex.com.github.EtherealERP.repository;

import leoguedex.com.github.EtherealERP.domain.ETUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ETUserRepository extends JpaRepository<ETUser, Long> {

    Optional<ETUser> findByEmail(String username);

}
