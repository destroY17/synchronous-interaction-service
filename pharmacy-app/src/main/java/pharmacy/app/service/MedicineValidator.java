package pharmacy.app.service;

import org.springframework.stereotype.Service;
import pharmacy.app.dto.Medicine;

@Service
public class MedicineValidator {

    public boolean isValid(Medicine medicine) {
        Integer cost = medicine.getCost();

        if (cost < 0) {
            return false;
        }

        return true;
    }
}
