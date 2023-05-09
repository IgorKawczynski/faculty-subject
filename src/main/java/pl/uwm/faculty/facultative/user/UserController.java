package pl.uwm.faculty.facultative.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public UserResponseDTO getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId).toResponseDto();
    }

    @GetMapping("/fullname/{userId}")
    public ResponseEntity<String> getUserFullNameById(@PathVariable Long userId) {
        return ResponseEntity.of(Optional.ofNullable(userService.getUserFullNameById(userId)));
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public UserEntity registerUser(@RequestBody UserEntity userCreate) {
        return userService.createUser(userCreate);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

}
