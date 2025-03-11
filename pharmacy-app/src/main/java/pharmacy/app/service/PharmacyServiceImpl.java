package pharmacy.app.service;

import pharmacy.app.api.PharmacyService;
import pharmacy.app.dto.Medicine;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Реализация сервис аптеки.
 */
@Service
public class PharmacyServiceImpl implements PharmacyService {
    private static Map<Long, Medicine> medicines = Map.of(
            1L, new Medicine("Анальгин", 150),
            2L, new Medicine("Аспирин", 150));

    @Override
    public Medicine getMedicine(Long id) {
        return medicines.get(id);
    }

    @Override
    public Medicine createMedicine(Medicine medicine) {
        medicines.put(3L, medicine);
        return medicine;
    }
}
