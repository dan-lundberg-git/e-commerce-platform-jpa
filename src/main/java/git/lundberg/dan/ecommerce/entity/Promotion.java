package git.lundberg.dan.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "promotions",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "promotion_code_unique",
                        columnNames = "code"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "code", columnDefinition = "text", nullable = false)
    private String code;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    // LAZY is already default, but being explicit
    @ManyToMany(mappedBy = "promotions", fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<>();
}
