package pl.uwm.faculty.facultative.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.uwm.faculty.facultative.global.exceptions.InvalidLengthException;
import pl.uwm.faculty.facultative.global.exceptions.InvalidSignsException;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
class UserService {

    private final UserRepository userRepository;
    public static final String NAME_REGEX = "[\\p{Alpha}\\p{Space}-.']++";

    public UserEntity createUser(UserRequestDTO userCreate) {
        if(!userCreate.firstName().matches(NAME_REGEX)) {
            throw new InvalidSignsException("firstName", "First name cannot contain invalid characters !");
        }
        if(!userCreate.lastName().matches(NAME_REGEX)) {
            throw new InvalidSignsException("lastName", "Last name cannot contain invalid characters !");
        }
        if(userCreate.firstName().length() > 30) {
            throw new InvalidLengthException("firstName", "First name must have less than 30 characters");
        }
        if(userCreate.lastName().length() > 30) {
            throw new InvalidLengthException("lastName", "Last name must have less than 30 characters");
        }
        if(userCreate.password().length() < 6) {
            throw new InvalidLengthException("password", "Password must have at least 6 characters");
        }
        var newUser = new UserEntity(userCreate.firstName(), userCreate.lastName(), userCreate.password());
        return userRepository.save(newUser);
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
