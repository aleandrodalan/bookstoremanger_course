package com.aleandrodalan.bookstoremanage.author.service;

import com.aleandrodalan.bookstoremanage.author.dto.AuthorDTO;
import com.aleandrodalan.bookstoremanage.author.entity.Author;
import com.aleandrodalan.bookstoremanage.author.exception.AuthorAlreadyExistsException;
import com.aleandrodalan.bookstoremanage.author.exception.AuthorNotFoundException;
import com.aleandrodalan.bookstoremanage.author.mapper.AuthorMapper;
import com.aleandrodalan.bookstoremanage.author.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final static AuthorMapper authorMapper = AuthorMapper.INSTANCE;

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorDTO create(AuthorDTO authorDTO) {
        verifyIfExists(authorDTO.getName());
        Author authorToCreate = authorMapper.toModel(authorDTO);
        Author createdAuthor = authorRepository.save(authorToCreate);

        return authorMapper.toDTO(createdAuthor);
    }

    public AuthorDTO findById(Long id) {
        Author foundAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));

        return authorMapper.toDTO(foundAuthor);
    }

    public List<AuthorDTO> findAll() {
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::toDTO)
                .collect(Collectors.toList());
    }

    private void verifyIfExists(String authorName) {
        authorRepository.findByName(authorName)
                .ifPresent(author -> {
                    throw new AuthorAlreadyExistsException(authorName);
                });
    }
}