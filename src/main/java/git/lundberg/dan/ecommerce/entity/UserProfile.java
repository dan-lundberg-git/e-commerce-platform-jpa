package git.lundberg.dan.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_profiles")
@Getter
@Setter
@NoArgsConstructor
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "nickname", nullable = false, length = 100)
    private String nickname;

    @Size(max = 100)
    @NotNull
    @Column(name = "phone_number", nullable = false, length = 100)
    private String phoneNumber;

    @Size(max = 500)
    @Column(name = "bio", length = 500)
    private String bio;
}
