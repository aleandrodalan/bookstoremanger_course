package com.aleandrodalan.bookstoremanage.author.mapper;

import com.aleandrodalan.bookstoremanage.author.dto.AuthorDTO;
import com.aleandrodalan.bookstoremanage.author.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    Author toModel(AuthorDTO authorDTO);

    AuthorDTO toDTO(Author author);
}
