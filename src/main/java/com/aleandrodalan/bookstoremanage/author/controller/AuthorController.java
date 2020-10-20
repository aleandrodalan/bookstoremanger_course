package com.aleandrodalan.bookstoremanage.author.controller;

import com.aleandrodalan.bookstoremanage.author.dto.AuthorDTO;
import com.aleandrodalan.bookstoremanage.author.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController implements AuthorControllerDocs {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDTO create(@RequestBody @Valid AuthorDTO authorDTO) {
        return authorService.create(authorDTO);
    }

    @GetMapping("/{id}")
    public AuthorDTO findById(@PathVariable("id") Long id) {
        return authorService.findById(id);
    }
}
