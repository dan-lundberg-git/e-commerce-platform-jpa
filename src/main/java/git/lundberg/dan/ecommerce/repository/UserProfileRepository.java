package git.lundberg.dan.ecommerce.repository;

import git.lundberg.dan.ecommerce.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    List<UserProfile> findByNicknameIgnoreCase(String nickname);

    List<UserProfile> findByPhoneNumberLike(String phoneNumber);

    List<UserProfile> findByPhoneNumberContains(String phoneNumber);
}
