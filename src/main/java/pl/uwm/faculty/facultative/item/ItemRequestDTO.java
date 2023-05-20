package pl.uwm.faculty.facultative.item;

import lombok.Builder;

public record ItemRequestDTO(Long id,
                             String itemName,
                             String description,
                             Double price,
                             Long userId) {

    @Builder
    public ItemRequestDTO {}
}
