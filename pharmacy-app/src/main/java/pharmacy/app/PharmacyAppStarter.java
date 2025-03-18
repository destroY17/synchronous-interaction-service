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

        Server server = ServerBuilder.forPort(9022)
                .addService(new MedicineGrpcServiceImpl())
                .build();

        server.start();
        server.awaitTermination();
    }
}
