package com.aleandrodalan.bookstoremanage.books.repository;

import com.aleandrodalan.bookstoremanage.books.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
