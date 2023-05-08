package pl.uwm.faculty.facultative.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
class UserCRUDService {

    private final UserRepository userRepository;

    public UserEntity createUser(UserEntity userCreate) {
        return userRepository.save(userCreate);
    }

    public Optional<UserEntity> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public String getUserFullNameById(Long userId) {
        return userRepository.findById(userId).get().getFullName();
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
