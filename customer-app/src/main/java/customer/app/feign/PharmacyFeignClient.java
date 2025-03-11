package customer.app.feign;

import customer.app.dto.Medicine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Test feign client with JSON.
 */
@FeignClient(value = "feignDemo", url = "localhost:8485/pharmacy")
public interface PharmacyFeignClient {

    @GetMapping("/medicines/{id}")
    Medicine getMedicine(@PathVariable Long id);

    @PostMapping("/medicines/create")
    Medicine create(Medicine medicine);

}
