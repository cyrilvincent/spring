package formation.spring.iod;

import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {

    public MyEntity getById(int id) {
        return new MyEntity(id);
    }

    public LombokEntity getByLombokId(int id) {
        return new LombokEntity(id);
    }
}
