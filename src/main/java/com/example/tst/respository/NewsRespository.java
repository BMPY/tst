package com.example.tst.respository;

import com.example.tst.entity.NewsEntity;
import org.springframework.data.repository.CrudRepository;

public interface NewsRespository extends CrudRepository<NewsEntity, Long> {
}
