package pharmacy.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import pharmacy.app.dto.Medicine;

@SpringJUnitConfig(classes = {MedicineValidator.class, MedicinesServiceImpl.class})
public class MedicinesServiceIntegrTest {

    @Autowired
    private MedicineValidator medicineValidator;

    @Autowired
    private MedicinesServiceImpl medicinesService;

    @Test
    void shouldCreateMedicineIfMedicineIsValid() {
        Medicine medicine = new Medicine();
        medicine.setCost(5);
        medicine.setName("asdasd");

        Medicine medicine1 = medicinesService.create(medicine);

        Assertions.assertEquals(medicine, medicine1);
    }
}
