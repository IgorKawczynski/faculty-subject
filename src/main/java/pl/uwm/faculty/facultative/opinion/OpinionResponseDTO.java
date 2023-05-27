package pl.uwm.faculty.facultative.opinion;

import lombok.Builder;

public record OpinionResponseDTO(String opinion, Integer rate, String itemName) {

    @Builder
    public OpinionResponseDTO {}
}
