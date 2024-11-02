package com.dmg.sistema_dmg_backend.auth.persitence.repository;

import com.dmg.sistema_dmg_backend.auth.persitence.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface RoleRepository extends ListCrudRepository<RoleEntity, Long> {

}
