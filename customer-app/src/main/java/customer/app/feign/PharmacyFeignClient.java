package customer.app.feign;

import customer.app.dto.Medicine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Фейн-клиент для взаимодействия с сервисом аптеки.
 */
@FeignClient(value = "feignDemo", url = "localhost:8485/pharmacy")
public interface PharmacyFeignClient {

    @GetMapping("/medicines/{id}")
    Medicine getMedicine(@PathVariable Long id);

    @PostMapping("/medicines/create")
    Medicine create(Medicine medicine);

    @DeleteMapping("/medicines/delete/{id}")
    String delete(@PathVariable Long id);

    @PutMapping("/medicines/update/{id}")
    Medicine update(@PathVariable Long id, Medicine medicine);

}
