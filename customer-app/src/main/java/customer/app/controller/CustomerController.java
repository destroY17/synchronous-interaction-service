package customer.app.controller;

import customer.app.feign.PharmacyFeignClient;
import lombok.RequiredArgsConstructor;
import customer.app.dto.Medicine;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customer/medicines")
@RequiredArgsConstructor
public class CustomerController {

    private final PharmacyFeignClient pharmacyFeignClient;

    @GetMapping("/{id}")
    public Medicine getMedicine(@PathVariable Long id) {
        return pharmacyFeignClient.getMedicine(id);
    }

    @PostMapping
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return pharmacyFeignClient.create(medicine);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return pharmacyFeignClient.delete(id);
    }

    @PutMapping("/{id}")
    public Medicine update(@PathVariable Long id, @RequestBody Medicine updateMedicine) {
        return pharmacyFeignClient.update(id, updateMedicine);
    }
}
