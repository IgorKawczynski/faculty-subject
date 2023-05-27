package pl.uwm.faculty.facultative.opinion;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.uwm.faculty.facultative.item.ItemRepository;
import pl.uwm.faculty.facultative.user.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class OpinionService {

    private final OpinionRepository opinionRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;


    public List<OpinionResponseDTO> getAllOpinions() {
        return opinionRepository
                .findAll()
                .stream()
                .map(OpinionEntity::toOpinionResponseDTO)
                .toList();
    }

    public void addOpinion(OpinionRequestDTO opinion) {
        var item = itemRepository.findById(opinion.itemId())
                .orElseThrow(
                        () -> new NoSuchElementException("There is no item with such id.")
                );
        var reviewer = userRepository.findById(opinion.userId())
                .orElseThrow(
                        () -> new NoSuchElementException("There is no user with such id.")
                );
        var newOpinion = new OpinionEntity(opinion.opinion(), opinion.rate(), item, reviewer);
        opinionRepository.save(newOpinion);
    }

}
