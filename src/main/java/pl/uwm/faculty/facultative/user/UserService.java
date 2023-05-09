package pl.uwm.faculty.facultative.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
class UserService {

    private final UserRepository userRepository;

    public UserEntity createUser(UserEntity userCreate) {
        return userRepository.save(userCreate);
    }

    public UserEntity getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User with given id does not exist!"));
    }

    public String getUserFullNameById(Long userId) {
        return userRepository.findById(userId).get().getFullName();
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(UserEntity::toResponseDto)
                .toList();
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
