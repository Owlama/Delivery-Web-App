package ng.com.nokt.demodelivery.services;

import ng.com.nokt.demodelivery.entites.Item;
import ng.com.nokt.demodelivery.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemService { // ✅ Now implements the interface

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item createItem(Item item) {
        String generatedCode = "ITEM-" + UUID.randomUUID().toString().substring(0, 6);
        item.setCode(generatedCode);
        return itemRepository.save(item);
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with ID: " + id));
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteItem(Long id) { // ✅ Uncommented to match the interface
        if (!itemRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete: Item not found with ID: " + id);
        }
        itemRepository.deleteById(id);
    }
}