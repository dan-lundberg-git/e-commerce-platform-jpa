package git.lundberg.dan.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user_profiles")
@Getter
@Setter
@NoArgsConstructor
public class UserProfile {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @NotNull
    @Column(name = "nickname", columnDefinition = "text", nullable = false)
    private String nickname;

    @NotNull
    @Column(name = "phone_number", columnDefinition = "text", nullable = false)
    private String phoneNumber;

    @Column(name = "bio", columnDefinition = "text")
    private String bio;

    @OneToOne(mappedBy = "userProfile")
    private Customer customer;
}
