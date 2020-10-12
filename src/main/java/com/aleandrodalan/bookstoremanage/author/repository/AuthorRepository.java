package com.aleandrodalan.bookstoremanage.author.repository;

import com.aleandrodalan.bookstoremanage.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
