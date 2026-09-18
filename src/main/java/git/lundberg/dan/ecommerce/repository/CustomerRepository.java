package git.lundberg.dan.ecommerce.repository;

import git.lundberg.dan.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmailIgnoreCase(String email);

    List<Customer> findByLastNameIgnoreCase(String lastName);

    List<Customer> findByAddress_CityIgnoreCase(String addressCity);
}
