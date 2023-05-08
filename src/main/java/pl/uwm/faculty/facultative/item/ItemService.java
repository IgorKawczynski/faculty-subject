package pl.uwm.faculty.facultative.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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

    private final static Integer PAGESIZE = 5;
    private final ItemRepository itemRepository;

    public List<ItemEntity> getAllItems(){
        return itemRepository.findAll();
    }

    public ItemEntity getItemById(Long id){
        return itemRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Item with id: " + id + " does not exist!"));
    }

    public void addItem(ItemEntity item) {
        itemRepository.save(item);
    }

    public String deleteItem(Long id) {
        var item =
                itemRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Item with id: " + id + " does not exist!"));
        itemRepository.delete(item);
        return "Item with id: " + id + " deleted successfully!";
    }

}
