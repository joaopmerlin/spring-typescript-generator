package com.spring.typescript.generator.samplemaven.data;

import com.spring.typescript.generator.samplemaven.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoData extends JpaRepository<Grupo, Long> {
}
