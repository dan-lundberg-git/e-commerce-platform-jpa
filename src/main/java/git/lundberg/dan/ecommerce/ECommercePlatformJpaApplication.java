package git.lundberg.dan.ecommerce;

import git.lundberg.dan.ecommerce.entity.Address;
import git.lundberg.dan.ecommerce.repository.AddressRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ECommercePlatformJpaApplication {

    static void main(String[] args) {
        SpringApplication.run(ECommercePlatformJpaApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AddressRepository addressRepository) {
        return args -> {
            Address address = new Address("Testgatan 1", "Test", "12345");
            addressRepository.save(address);
        };
    }

}
