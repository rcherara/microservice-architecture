package ca.rcherara.services.dealership.repositories.redis;

import ca.rcherara.services.dealership.domain.Dealership;
import ca.rcherara.services.dealership.domain.RandomIdGenerator;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class RedisDealershipRepository implements CrudRepository<Dealership, String> {
    public static final String DEALERSHIP_KEY = "dealerships";

    private final RandomIdGenerator idGenerator;
    private final HashOperations<String, String, Dealership> hashOps;

    public RedisDealershipRepository(RedisTemplate<String, Dealership> redisTemplate) {
        this.hashOps = redisTemplate.opsForHash();
        this.idGenerator = new RandomIdGenerator();
    }

    @Override
    public <S extends Dealership> S save(S dealership) {
        if (dealership.getId() == null) {
            dealership.setId(idGenerator.generateId());
        }

        hashOps.put(DEALERSHIP_KEY, dealership.getId(), dealership);

        return dealership;
    }

    @Override
    public <S extends Dealership> Iterable<S> saveAll(Iterable<S> dealerships) {
        List<S> result = new ArrayList<>();

        for (S entity : dealerships) {
            save(entity);
            result.add(entity);
        }

        return result;
    }

    @Override
    public Optional<Dealership> findById(String id) {
        return Optional.ofNullable(hashOps.get(DEALERSHIP_KEY, id));
    }

    @Override
    public boolean existsById(String id) {
        return hashOps.hasKey(DEALERSHIP_KEY, id);
    }

    @Override
    public Iterable<Dealership> findAll() {
        return hashOps.values(DEALERSHIP_KEY);
    }

    @Override
    public Iterable<Dealership> findAllById(Iterable<String> ids) {
        return hashOps.multiGet(DEALERSHIP_KEY, convertIterableToList(ids));
    }

    @Override
    public long count() {
        return hashOps.keys(DEALERSHIP_KEY).size();
    }

    @Override
    public void deleteById(String id) {
        hashOps.delete(DEALERSHIP_KEY, id);
    }

    @Override
    public void delete(Dealership dealership) {
        hashOps.delete(DEALERSHIP_KEY, dealership.getId());
    }

    @Override
    public void deleteAll(Iterable<? extends Dealership> dealerships) {
        for (Dealership dealership : dealerships) {
            delete(dealership);
        }
    }

    @Override
    public void deleteAll() {
        Set<String> ids = hashOps.keys(DEALERSHIP_KEY);
        for (String id : ids) {
            deleteById(id);
        }
    }

    private <T> List<T> convertIterableToList(Iterable<T> iterable) {
        List<T> list = new ArrayList<>();
        for (T object : iterable) {
            list.add(object);
        }
        return list;
    }
}
