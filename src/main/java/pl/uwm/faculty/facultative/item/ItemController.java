package pl.uwm.faculty.facultative.item;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * REST Controller for user's items
 *
 */
@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/all")
    public List<ItemResponseDTO> getItems() {
        return itemService.getAllItems();
    }

    @GetMapping("")
    public ItemEntity getItemById(@RequestParam("id") Long id) {
        return itemService.getItemById(id);
    }

    @PostMapping(path = "", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void addItem(@RequestBody ItemEntity item) {
        itemService.addItem(item);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteItemById(@PathVariable Long id) {
        return itemService.deleteItem(id);
    }

    @GetMapping("/pomocy")
    public String testRest() {
        return "POMOCY";
    }
}
