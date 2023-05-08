package pl.uwm.faculty.facultative.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import pl.uwm.faculty.facultative.global.GlobalEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity extends GlobalEntity {

    String firstName;
    String lastName;
    String password;

    public UserEntity(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
