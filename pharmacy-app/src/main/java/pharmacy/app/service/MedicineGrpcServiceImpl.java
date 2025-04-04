package pharmacy.app.service;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import proto.MedicineProto;
import proto.MedicineServiceGrpc.MedicineServiceImplBase;

@Slf4j
public class MedicineGrpcServiceImpl extends MedicineServiceImplBase {
    @Override
    public void getMedicine(MedicineProto.MedicineProtoBuf request, StreamObserver<MedicineProto.MedicineProtoBuf> responseObserver) {
        // Обработка запроса и формирование ответа
        MedicineProto.MedicineProtoBuf medicine = MedicineProto.MedicineProtoBuf.newBuilder()
                .setName("Аспирин")
                .setCost(100)
                .build();

        // отправляем ответ
        responseObserver.onNext(medicine);
        log.info("Выдано лекарство {}, стоимостью {} через gRPC", medicine.getName(), medicine.getCost());
        // уведомление клиента о завершении обработки запроса
        responseObserver.onCompleted();
    }
}

