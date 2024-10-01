package com.sci_all.demo.persistance.repositories.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface IBaseRepository<T, ID> extends JpaRepository<T, ID> {

    Optional<T> findByUuid(UUID uuid);

}
