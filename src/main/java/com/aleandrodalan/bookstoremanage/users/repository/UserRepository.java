package com.aleandrodalan.bookstoremanage.users.repository;

import com.aleandrodalan.bookstoremanage.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
