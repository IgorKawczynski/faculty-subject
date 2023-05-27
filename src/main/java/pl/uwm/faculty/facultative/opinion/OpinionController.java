package pl.uwm.faculty.facultative.opinion;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/opinions")
@RequiredArgsConstructor
public class OpinionController {

    private final OpinionService opinionService;

    @GetMapping("/all")
    public List<OpinionResponseDTO> getOpinions() {
        return  opinionService.getAllOpinions();
    }

    @PostMapping(path = "", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void addOpinion(@RequestBody OpinionRequestDTO opinion) {
        opinionService.addOpinion(opinion);
    }

}
