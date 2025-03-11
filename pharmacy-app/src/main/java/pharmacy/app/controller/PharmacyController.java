package pharmacy.app.controller;

import pharmacy.app.api.PharmacyService;
import pharmacy.app.dto.Medicine;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/medicines")
public class PharmacyController {

    private final PharmacyService pharmacyService;

    @GetMapping("/{id}")
    public Medicine getMedicine(@PathVariable Long id) {
        return pharmacyService.getMedicine(id);
    }

    @PostMapping("/create")
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return pharmacyService.createMedicine(medicine);
    }

}
