package pl.uwm.faculty.facultative.opinion;

public record OpinionRequestDTO(Long id,
                                String opinion,
                                Integer rate,
                                Long itemId,
                                Long userId) {
}
