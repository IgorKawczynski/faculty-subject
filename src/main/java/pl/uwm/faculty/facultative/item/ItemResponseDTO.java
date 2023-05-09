package pl.uwm.faculty.facultative.item;

import lombok.Builder;

public record ItemResponseDTO(String itemName, String description, Double price) {

    @Builder
    public ItemResponseDTO {}
}
