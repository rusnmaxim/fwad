package com.example.fwad.controllers;

import com.example.fwad.models.Item;
import com.example.fwad.models.ItemPut;
import com.example.fwad.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/item")
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;

    @GetMapping
    public ResponseEntity<List<Item>> getItems(){
    return new ResponseEntity<>(itemRepository.findAll(), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity updateItem(@PathVariable Long id, @RequestBody ItemPut item){
        Item item1 = Item.builder()
                .id(id)
                .name(item.getName())
                .price(item.getPrice())
                .category(item.getCategory())
                .description(item.getDescription())
                .build();
        itemRepository.save(item1);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Item> createItem(@RequestBody Item item){
        itemRepository.save(item);
        if(item.getId() != null){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity updateItem(@PathVariable Long id){
        itemRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
