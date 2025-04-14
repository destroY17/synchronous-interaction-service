package pharmacy.app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import pharmacy.app.api.MedicinesService;
import pharmacy.app.dto.Medicine;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/medicines")
@Tag(name = "Контроллер лекарств", description = "Контроллер для лекарств")
@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Запрос выполнен успешно"),
@ApiResponse(responseCode = "401", description = "Ошибка доступа(пользователь не авторизован)")})
public class MedicinesController {

    private final MedicinesService medicinesService;

    @GetMapping("/{id}")
    @Operation(summary = "Получить лекарство из аптеки")
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
