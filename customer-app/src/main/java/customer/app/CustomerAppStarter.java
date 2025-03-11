package customer.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;


@EnableFeignClients(basePackages = "customer.app.feign")
@ImportAutoConfiguration({FeignAutoConfiguration.class})
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Project Api", version = "1.0", description = "Сервис клиента аптеки"))
public class CustomerAppStarter {

    /**
     * Запуск приложения.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(CustomerAppStarter.class, args);
    }
}
