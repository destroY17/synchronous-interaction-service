package pharmacy.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pharmacy.app.dto.Medicine;
import pharmacy.app.exception.PharmacyException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MedicinesServiceImplTest {

    @Mock
    private MedicineValidator medicineValidator;

    @InjectMocks
    private MedicinesServiceImpl medicinesService;

    @Test
    void shouldCreateMedicine() {
        // Подготовка
        Medicine expected = new Medicine();
        expected.setName("");
        expected.setCost(5);

        Mockito.when(medicineValidator.isValid(expected))
                .thenReturn(true);

        // Действие
        Medicine actual = medicinesService.create(expected);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldThrowExceptionIfMedicineIsNotValid() {
        // Подготовка
        Medicine medicine = new Medicine();

        Mockito.when(medicineValidator.isValid(medicine))
                .thenReturn(false);

        String expectedMessage = "Не удалось создать лекарство: " + medicine;

        // Действие
        Executable executable = () -> medicinesService.create(medicine);

        // Проверка
        PharmacyException actualException = assertThrows(PharmacyException.class, executable);
        Assertions.assertEquals(expectedMessage, actualException.getMessage());
    }


}