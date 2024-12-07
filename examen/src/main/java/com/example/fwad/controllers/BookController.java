package com.example.fwad.controllers;

import com.example.fwad.models.Books;
import com.example.fwad.models.BookPut;
import com.example.fwad.repositories.BookRepository;
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
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<List<Books>> getBook(){
    return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity updateBook(@PathVariable Long id, @RequestBody BookPut bookPut){
        Books books1 = Books.builder()
                .id(id)
                .name(bookPut.getName())
                .description(bookPut.getDescription())
                .author(bookPut.getAuthor())
                .pages(bookPut.getPages())
                .build();
        bookRepository.save(books1);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Books> createBook(@RequestBody Books books){
       Books b = bookRepository.save(books);
        if(b.getId() != null){
            return new ResponseEntity<>(books, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable Long id){
        bookRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
