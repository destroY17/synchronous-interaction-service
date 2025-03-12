package pharmacy.app.api;

import pharmacy.app.dto.Medicine;

/**
 * Сервис аптеки.
 */
public interface MedicinesService {

    /**
     * Получить лекарство по id.
     *
     * @param id идентификатор лекарства.
     * @return сущность лекарства
     */
    Medicine get(Long id);


    /**
     * Добавить лекарство в аптеку.
     *
     * @param medicine сущность лекарства
     * @return лекарство
     */
    Medicine create(Medicine medicine);

    /**
     * Удалить лекарство из аптеки по идентификатору.
     *
     * @param id идентификатор лекарства
     * @return удаленное лекарство
     */
    Medicine delete(Long id);

    /**
     * Обновить лекарство из аптеки по идентификатору.
     *
     * @param id идентификатор лекарства
     * @param medicine обновленное лекарство
     * @return обновленное лекарство
     */
    Medicine update(Long id, Medicine medicine);
}
