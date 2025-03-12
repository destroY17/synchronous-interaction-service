package customer.app.service;

import customer.app.api.GrpcService;
import customer.app.dto.Medicine;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import proto.MedicineProto;
import proto.MedicineServiceGrpc;


@Slf4j
@Service
@RequiredArgsConstructor
public class GrpcServiceImpl implements GrpcService {

    @Override
    public Medicine getMedicine() {
        log.info("Начало взаимодействия с аптекой через GRPC");
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9022)
                .usePlaintext()
                .build();

        MedicineServiceGrpc.MedicineServiceBlockingStub pharmacyService = MedicineServiceGrpc.newBlockingStub(channel);

        MedicineProto.MedicineProtoBuf request = MedicineProto.MedicineProtoBuf.newBuilder().build();
        MedicineProto.MedicineProtoBuf response = pharmacyService.getMedicine(request);

        log.info("Получено лекарство: {}, стоимостью: {}", response.getName(), response.getCost());
        channel.shutdown();

        return new Medicine(response.getName(), (int) response.getCost());
    }
}
