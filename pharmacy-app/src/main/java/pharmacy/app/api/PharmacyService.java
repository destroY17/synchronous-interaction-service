package pharmacy.app.api;

import pharmacy.app.dto.Medicine;

/**
 * Сервис аптеки.
 */
public interface PharmacyService {

    /**
     * Получить лекарство по id.
     *
     * @param id идентификатор лекарства.
     * @return сущность лекарства
     */
    Medicine getMedicine(Long id);


    /**
     * Добавить лекарство в аптеку.
     *
     * @param medicine сущность лекарства
     * @return лекарство
     */
    Medicine createMedicine(Medicine medicine);
}
