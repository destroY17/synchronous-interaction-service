package customer.app.controller;

import customer.app.feign.PharmacyFeignClient;
import lombok.RequiredArgsConstructor;
import customer.app.dto.Medicine;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final PharmacyFeignClient pharmacyFeignClient;

    @GetMapping("/medicines/{id}")
    public Medicine getMedicine(@PathVariable Long id) {
        return pharmacyFeignClient.getMedicine(id);
    }

    @PostMapping("/medicines/create")
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return pharmacyFeignClient.create(medicine);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return pharmacyFeignClient.delete(id);
    }

    @PutMapping("/update/{id}")
    public Medicine update(@PathVariable Long id, @RequestBody Medicine updateMedicine) {
        return pharmacyFeignClient.update(id, updateMedicine);
    }
}
