package pl.uwm.faculty.facultative.user;

import lombok.Builder;

public record UserRequestDTO(Long id,
                             String firstName,
                             String lastName,
                             String password) {

    @Builder
    public UserRequestDTO {}
}
