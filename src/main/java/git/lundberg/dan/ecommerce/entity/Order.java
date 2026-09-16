package git.lundberg.dan.ecommerce.entity;

import git.lundberg.dan.ecommerce.utils.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    private Instant orderDate;

    private OrderStatus orderStatus;

    // TODO: Check if this is correct
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
