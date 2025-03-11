package pharmacy.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Project Api", version = "1.0", description = "Сервис аптеки"))
public class PharmacyAppStarter {

    /**
     * Запуск приложения.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(PharmacyAppStarter.class, args);
    }
}
