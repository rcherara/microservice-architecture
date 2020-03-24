package ca.rcherara.services.dealership.repositories.jpa;

import ca.rcherara.services.dealership.domain.Dealership;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile({"!mongodb", "!redis"})
public interface JpaDealershipRepository extends JpaRepository<Dealership, String> {
}
