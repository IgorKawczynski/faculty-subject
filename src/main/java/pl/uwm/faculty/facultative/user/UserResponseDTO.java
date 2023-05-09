package pl.uwm.faculty.facultative.user;

import lombok.Builder;

public record UserResponseDTO(Long id, String firstName, String lastName) {

    @Builder
    public UserResponseDTO {}
}
