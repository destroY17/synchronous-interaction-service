package pharmacy.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicine implements Serializable {

    /**
     * Название лекарства.
     */
    String name;

    /**
     * Стоимость лекарства.
     */
    Integer cost;

}

