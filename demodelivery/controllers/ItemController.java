package ng.com.nokt.demodelivery.controllers;

import ng.com.nokt.demodelivery.entites.Item;
import ng.com.nokt.demodelivery.services.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
@CrossOrigin(origins = "http://localhost:63342")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @PostMapping("/create")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item newItem = itemService.createItem(item);
        return ResponseEntity.ok(newItem);
    }

    @GetMapping // ✅ This was missing
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }
}