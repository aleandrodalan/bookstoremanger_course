package com.aleandrodalan.bookstoremanage.publishers.repository;

import com.aleandrodalan.bookstoremanage.publishers.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
