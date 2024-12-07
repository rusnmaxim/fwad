package com.example.fwad;

import com.example.fwad.controllers.BookController;
import com.example.fwad.models.Books;
import com.example.fwad.repositories.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Example;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BookRepository bookRepository;

    ObjectMapper ob = new ObjectMapper();



    @Test
    void testCreateBook() throws Exception {
        Books books = Books.builder().name("NewBook").author("Author").build();
        Books books2 = Books.builder().id(1L).name("NewBook").author("Author").build();

        when(bookRepository.save(any())).thenReturn(books2);
        mockMvc.perform(post("/api/books").contentType(MediaType.APPLICATION_JSON).content(ob.writeValueAsString(books)))
                .andExpect(status().isOk())
                .andExpect(content().json(ob.writeValueAsString(books2)));
    }

    @Test
    void testGetBook() throws Exception {
        Books books2 = Books.builder().id(1L).name("NewBook").author("Author").build();

        when(bookRepository.findAll()).thenReturn(List.of(books2));
        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(content().json(ob.writeValueAsString(List.of(books2))));
    }
}
