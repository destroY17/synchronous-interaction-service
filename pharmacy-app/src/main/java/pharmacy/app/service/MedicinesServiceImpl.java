package pharmacy.app.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pharmacy.app.api.MedicinesService;
import pharmacy.app.dto.Medicine;

import java.util.Random;

/**
 * Реализация сервис аптеки.
 */
@Slf4j
@Service
public class MedicinesServiceImpl implements MedicinesService {

    @Override
    public Medicine get(Long id) {
        Medicine medicine = new Medicine();
        medicine.setCost(new Random().nextInt());
        medicine.setName("Лекарство");
        log.info("Выдано лекарство из аптеки с названием {} и стоимостью {}", medicine.getName(), medicine.getCost());
        return medicine;
    }

    @Override
    public Medicine create(Medicine medicine) {
        log.info("Добавлено лекарство в аптеку с названием {} и стоимостью {}", medicine.getName(), medicine.getCost());
        return medicine;
    }

    @Override
    public Medicine delete(Long id) {
        log.info("Удалено лекарство из аптеки с идентификатором {}", id);
        return new Medicine("Удаленное лекарство", 1);
    }

    @Override
    public Medicine update(Long id, Medicine medicine) {
        log.info("Обновлено лекарство из аптеки с идентификатором {}", id);
        return medicine;
    }
}
