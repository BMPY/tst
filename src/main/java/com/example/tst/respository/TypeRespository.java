package com.example.tst.respository;

import com.example.tst.entity.TypeEntity;
import org.springframework.data.repository.CrudRepository;

public interface TypeRespository extends CrudRepository<TypeEntity, Long> {
}