package formation.spring.iod;

import org.springframework.stereotype.Component;

@Component
public class MyEntity {

    public MyEntity(int value) {
        this.value = value;
    }

    public MyEntity() {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
