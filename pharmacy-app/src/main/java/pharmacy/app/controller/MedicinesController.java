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
@Tag(name = "Контроллер лекарств", description = "Контроллер для лекарств")
@RequestMapping("/medicines")
@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Успешное обновление схемы"),
        @ApiResponse(responseCode = "404", description = "Схема не найдена"),
        @ApiResponse(responseCode = "401", description = "Ошибка доступа (пользователь не авторизован)"),
        @ApiResponse(responseCode = "403", description = "Ошибка доступа (пользователь не имеет прав на выполнение операции)"),
        @ApiResponse(responseCode = "400", description = "Ошибка запроса (отсутствует или неверный запрос)"),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")})
public class MedicinesController {

    private final MedicinesService medicinesService;

    @GetMapping("/{id}")
    @Operation(summary = "Получить лекарство из аптеки")
    public Medicine get(@PathVariable Long id) {
        return medicinesService.get(id);
    }

    @PostMapping
    @Operation(summary = "Добавить лекарство в аптеку")
    public Medicine create(@RequestBody Medicine medicine) {
        return medicinesService.create(medicine);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Убрать лекарство из аптеки")
    public String delete(@PathVariable Long id) {
        return medicinesService.delete(id).getName();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить лекарство в аптеке")
    public Medicine update(@PathVariable Long id, @RequestBody Medicine updateMedicine) {
        return medicinesService.update(id, updateMedicine);
    }
}
