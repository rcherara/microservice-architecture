package ca.rcherara.services.dealership.repositories;

import java.util.Collection;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.init.Jackson2ResourceReader;

import ca.rcherara.services.dealership.domain.Dealership;

public class DealershipRepositoryPopulator implements ApplicationListener<ApplicationReadyEvent> {
    private final Jackson2ResourceReader resourceReader;
    private final Resource sourceData;

    public DealershipRepositoryPopulator() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        resourceReader = new Jackson2ResourceReader(mapper);
        sourceData = new ClassPathResource("dealership.json");
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        CrudRepository dealershipRepository =
                BeanFactoryUtils.beanOfTypeIncludingAncestors(event.getApplicationContext(), CrudRepository.class);

        if (dealershipRepository != null && dealershipRepository.count() == 0) {
            populate(dealershipRepository);
        }
    }

    @SuppressWarnings("unchecked")
    private void populate(CrudRepository repository) {
        Object entity = getEntityFromResource(sourceData);

        if (entity instanceof Collection) {
            for (Dealership dealership : (Collection<Dealership>) entity) {
                if (dealership != null) {
                    repository.save(dealership);
                }
            }
        } else {
            repository.save(entity);
        }
    }

    private Object getEntityFromResource(Resource resource) {
        try {
            return resourceReader.readFrom(resource, this.getClass().getClassLoader());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
