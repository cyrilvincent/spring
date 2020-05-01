package formation.spring.iod;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    private final MyRepository repository;

    public MyService(MyRepository repository) {
        this.repository = repository;
    }

    public MyEntity getById(int id) {
        return repository.getById(id);
    }

    public LombokEntity getByLombokId(int id) {
        return repository.getByLombokId(id);
    }

}
