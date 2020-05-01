package formation.spring.iod;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
//@Getter
//@Setter
@ToString
@Data
public class LombokEntity {

    private int value;
}
