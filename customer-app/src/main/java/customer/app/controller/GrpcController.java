package customer.app.controller;

import customer.app.api.GrpcService;
import customer.app.dto.Medicine;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proto.MedicineProto;

@Slf4j
@RestController
@RequestMapping("/grpc")
@RequiredArgsConstructor
public class GrpcController {

    private final GrpcService grpcService;

    @GetMapping(value = "/getMedicine")
    public Medicine getMedicine() {
        return grpcService.getMedicine();
    }
}
