package customer.app.api;

import customer.app.dto.Medicine;
import proto.MedicineProto;

/**
 * Сервис для работы с GRPC.
 */
public interface GrpcService {

    /**
     * Метод для получения лекарства из сервиса аптеки через GRPC.
     *
     * @return лекарство
     */
    Medicine getMedicine();
}
