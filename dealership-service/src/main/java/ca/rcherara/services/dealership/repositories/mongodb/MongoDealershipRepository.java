package ca.rcherara.services.dealership.repositories.mongodb;

import ca.rcherara.services.dealership.domain.Dealership;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("mongodb")
public interface MongoDealershipRepository extends MongoRepository<Dealership, String> {
}