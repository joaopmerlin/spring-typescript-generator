package com.spring.typescript.generator.samplemaven.data;

import com.spring.typescript.generator.samplemaven.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserData extends JpaRepository<User, Long> {
}
