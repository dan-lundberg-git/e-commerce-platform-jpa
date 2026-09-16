package git.lundberg.dan.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ECommercePlatformJpaApplication {

    static void main(String[] args) {
        SpringApplication.run(ECommercePlatformJpaApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(AddressRepository addressRepository) {
//        return args -> {
//            Address address = new Address("Testgatan 1", "Test", "12345");
//            addressRepository.save(address);
//        };
//    }
}
