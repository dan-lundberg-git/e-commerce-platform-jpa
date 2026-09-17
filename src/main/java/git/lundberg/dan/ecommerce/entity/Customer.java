package git.lundberg.dan.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(
        name = "customers",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "customer_email_unique",
                        columnNames = "email"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "first_name", columnDefinition = "text", nullable = false)
    private String firstName;

    @Column(name = "last_name", columnDefinition = "text", nullable = false)
    private String lastName;

    @Column(name = "email", columnDefinition = "text", nullable = false)
    private String email;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    // Mandatory 1:1 — every customer needs an address
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "fk_address_id"), nullable = false, unique = true)
    private Address address;

    // Optional 1:1 — a customer might not have set up a profile yet
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", foreignKey = @ForeignKey(name = "fk_profile_id"), unique = true)
    private UserProfile userProfile;

    // For convenience and visibility, add mappedBy to Order
    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

    @PrePersist
    void prePersist() {
        this.createdAt = Instant.now();
    }
}
