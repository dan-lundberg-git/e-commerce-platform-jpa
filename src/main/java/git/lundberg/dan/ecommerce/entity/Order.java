package git.lundberg.dan.ecommerce.entity;

import git.lundberg.dan.ecommerce.utils.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "order_date", nullable = false)
    private Instant orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "text", nullable = false)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "fk_customer_id"), nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @PrePersist
    void prePersist() {
        this.orderDate = Instant.now();
    }
}
