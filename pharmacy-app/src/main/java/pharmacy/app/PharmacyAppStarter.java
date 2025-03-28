package pharmacy.app;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pharmacy.app.service.MedicineGrpcServiceImpl;

import java.io.IOException;

@SpringBootApplication
public class PharmacyAppStarter {

    /**
     * Запуск приложения.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(PharmacyAppStarter.class, args);

        //Создаем новый сервер, который будет работать на порту 9022
        Server server = ServerBuilder.forPort(9022)
                //Добавляем реализацию сервиса к серверу(Когда клиент делает вызов к этому сервису, сервер будет использовать методы из этой реализации)
                .addService(new MedicineGrpcServiceImpl())
                .build();


        //Запускаем сервер(Он начинает слушать входящие соединения от клиентов)
        server.start();
        //Этот метод блокирует текущий поток до тех пор, пока сервер не будет остановлен
        server.awaitTermination();
    }
}
