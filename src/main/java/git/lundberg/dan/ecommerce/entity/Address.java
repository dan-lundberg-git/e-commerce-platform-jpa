package git.lundberg.dan.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "street", columnDefinition = "text", nullable = false)
    private String street;

    @Column(name = "city", columnDefinition = "text", nullable = false)
    private String city;

    @Column(name = "zip_code", columnDefinition = "text", nullable = false)
    private String zipCode;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Customer customer;

    public Address(String street, String city, String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }
}
