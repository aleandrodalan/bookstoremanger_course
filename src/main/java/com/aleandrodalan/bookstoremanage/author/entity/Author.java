package com.aleandrodalan.bookstoremanage.author.entity;

import com.aleandrodalan.bookstoremanage.books.entity.Book;
import com.aleandrodalan.bookstoremanage.entity.Auditable;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Author extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "Integer default 0")
    private int age;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Book> books;
}
