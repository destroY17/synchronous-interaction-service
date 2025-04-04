package pharmacy.app.controller;

import pharmacy.app.api.MedicinesService;
import pharmacy.app.dto.Medicine;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/medicines")
public class MedicinesController {

    private final MedicinesService medicinesService;

    @GetMapping("/{id}")
    public Medicine get(@PathVariable Long id) {
        return medicinesService.get(id);
    }

    @PostMapping
    public Medicine create(@RequestBody Medicine medicine) {
        return medicinesService.create(medicine);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return medicinesService.delete(id).getName();
    }

    @PutMapping("/{id}")
    public Medicine update(@PathVariable Long id, @RequestBody Medicine updateMedicine) {
        return medicinesService.update(id, updateMedicine);
    }
}
