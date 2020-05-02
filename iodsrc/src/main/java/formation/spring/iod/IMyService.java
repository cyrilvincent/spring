package formation.spring.iod;

public interface IMyService {
    MyEntity getById(int id);

    LombokEntity getByLombokId(int id);
}
