package pl.uwm.faculty.facultative.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.uwm.faculty.facultative.user.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 *  Web Service of user's items
 *
 */
@Service
@RequiredArgsConstructor
class ItemService {
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public List<ItemResponseDTO> getAllItems(){
        return itemRepository
                .findAll()
                .stream()
                .map(ItemEntity::toItemResponseDTO)
                .toList();
    }

    public ItemEntity getItemById(Long id){
        return itemRepository
                .findById(id)
                .orElseThrow(
                        () -> new NoSuchElementException("Item with id: " + id + " does not exist!")
                );
    }

    public void addItem(ItemRequestDTO item) {
        var user = userRepository
                .findById(item.userId())
                .orElseThrow(
                        () -> new NoSuchElementException("There is no user with such id.")
                );
        var newItem = new ItemEntity(item.itemName(), item.description(), item.price(), user);
        itemRepository.save(newItem);
    }

    public String deleteItem(Long id) {
        var item =
                itemRepository
                .findById(id)
                .orElseThrow(
                        () -> new NoSuchElementException("Item with id: " + id + " does not exist!")
                );
        itemRepository.delete(item);
        return "Item with id: " + id + " deleted successfully!";
    }

}
