package formation.spring.iod;

import org.springframework.stereotype.Service;

@Service
public class MyService implements IMyService {

    private final MyRepository repository;

    public MyService(MyRepository repository) {
        this.repository = repository;
    }

    @Override
    public MyEntity getById(int id) {
        return repository.getById(id);
    }

    @Override
    public LombokEntity getByLombokId(int id) {
        return repository.getByLombokId(id);
    }

}
