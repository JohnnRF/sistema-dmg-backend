package com.dmg.sistema_dmg_backend.auth.persitence.repository;

import com.dmg.sistema_dmg_backend.auth.persitence.entity.UserEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends ListCrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
}
