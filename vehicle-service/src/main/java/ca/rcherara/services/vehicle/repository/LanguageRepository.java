package ca.rcherara.services.vehicle.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ca.rcherara.services.vehicle.model.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

    Language findByNameIgnoringCase(String name);
    Language findById(long id);

}