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
                //Создаётся gRPC-канал для связи с сервисом
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9022)
                //Нешифрованное соединение
                .usePlaintext()
                .build();

        //Создаётся блокирующий клиентский стуб для взаимодействия с сервисом MedicineService. Этот стуб будет использоваться для вызова методов gRPC.
        MedicineServiceGrpc.MedicineServiceBlockingStub pharmacyService = MedicineServiceGrpc.newBlockingStub(channel);

        //Создаётся объект запроса request типа MedicineProtoBuf. В данном случае он создаётся без каких-либо параметров (пустой запрос).
        MedicineProto.MedicineProtoBuf request = MedicineProto.MedicineProtoBuf.newBuilder().build();

        // Вызывается метод getMedicine на сервере с передачей созданного запроса
        MedicineProto.MedicineProtoBuf response = pharmacyService.getMedicine(request);

        log.info("Получено лекарство: {}, стоимостью: {}", response.getName(), response.getCost());

        //Закрывается gRPC-канал
        channel.shutdown();

        return new Medicine(response.getName(), (int) response.getCost());
    }
}
