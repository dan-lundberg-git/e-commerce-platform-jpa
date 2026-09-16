package git.lundberg.dan.ecommerce.entity;

import git.lundberg.dan.ecommerce.repository.AddressRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Save address to database")
class AddressTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void save_shouldPersistAddress() {
        Address address = new Address();
        address.setCity("Test");
        address.setStreet("Test street 1");
        address.setZipCode("12345");
    }
}