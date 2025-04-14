package pharmacy.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pharmacy.app.dto.Medicine;

@DisplayName("Тест для валидации лекарства")
class MedicineValidatorTest {

    private MedicineValidator medicineValidator = new MedicineValidator();

    // should + ожидаемый результат + when + условие
    // given(дано)-when (действие) - then(проверка)
    // ожидаемый - expected, получили - actual
    @Test
    @DisplayName("Метод должен вернуть true, если пришло валидное лекарство")
    void shouldReturnTrueWhenMedicineIsValid() {
        // Подготовка
        Medicine medicine = new Medicine();
        medicine.setName("Аспирин");
        medicine.setCost(5);

        boolean expected = true;

        // Действие
        boolean actual = medicineValidator.isValid(medicine);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    // название метода + ожидаемое значение + условие
    @Test
    void isValid_ReturnFalse_IfCostIsNegative() {
        // Подготовка
        Medicine medicine = new Medicine();
        medicine.setCost(-2);
        medicine.setName("Аспирин");

        boolean expected = false;

        // Действие
        boolean actual = medicineValidator.isValid(medicine);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

}