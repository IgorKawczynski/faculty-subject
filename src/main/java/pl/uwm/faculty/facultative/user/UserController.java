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

    private final UserCRUDService userCRUDService;

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<UserEntity>> getUserById(@PathVariable Long userId) {
        return ResponseEntity.of(Optional.ofNullable(userCRUDService.getUserById(userId)));
    }

    @GetMapping("/fullname/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getUserFullNameById(@PathVariable Long userId) {
        return ResponseEntity.of(Optional.ofNullable(userCRUDService.getUserFullNameById(userId)));
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<UserEntity> getAllUsers() {
        return userCRUDService.getAllUsers();
    }

    @PostMapping("/register")
    public UserEntity registerUser(@RequestBody UserEntity userCreate) {
        return userCRUDService.createUser(userCreate);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable Long userId) {
        userCRUDService.deleteUser(userId);
    }

}
