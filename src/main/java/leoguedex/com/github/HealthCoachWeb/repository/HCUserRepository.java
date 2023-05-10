package leoguedex.com.github.HealthCoachWeb.repository;

import leoguedex.com.github.HealthCoachWeb.domain.HCUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HCUserRepository extends JpaRepository<HCUser, Long> {

    HCUser findByEmail(String username);

}
