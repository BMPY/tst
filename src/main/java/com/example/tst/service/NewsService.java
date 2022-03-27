package com.example.tst.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.tst.entity.NewsEntity;
import com.example.tst.entity.TypeEntity;
import com.example.tst.exception.NotFoundNewsException;
import com.example.tst.exception.NotFoundTypeException;
import com.example.tst.model.*;
import com.example.tst.respository.NewsRespository;
import com.example.tst.respository.TypeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
    private NewsRespository newsRespository;
    private TypeRespository typeRespository;

    @Autowired
    public NewsService(NewsRespository newsRespository, TypeRespository typeRespository) {
        this.newsRespository = newsRespository;
        this.typeRespository = typeRespository;
    }

    public News post(NewsEntity news, Long typeId) {
        TypeEntity type = (TypeEntity)this.typeRespository.findById(typeId).get();
        news.setType(type);
        return News.toModel((NewsEntity)this.newsRespository.save(news));
    }
    public News post(NewsCreate news) {
        NewsEntity newsEntity = new NewsEntity();
        TypeEntity type = (TypeEntity)this.typeRespository.findById(news.getTypeId()).get();

        newsEntity.setType(type);
        newsEntity.setName(news.getName());
        newsEntity.setShortDescription(news.getShortDescription());
        newsEntity.setLongDescription(news.getLongDescription());

        return News.toModel((NewsEntity)this.newsRespository.save(newsEntity));
    }

    public List<News> getAllNews() {
        List<News> news = new ArrayList();
        Iterator var2 = this.newsRespository.findAll().iterator();

        while(var2.hasNext()) {
            NewsEntity entity = (NewsEntity)var2.next();
            news.add(News.toModel(entity));
        }

        return news;
    }

    public News getOneNews(Long id) throws NotFoundNewsException {
        Optional<NewsEntity> news = this.newsRespository.findById(id);
        if (news.isEmpty())
            throw new NotFoundNewsException("Not found the news");

        return News.toModel(news.get());
    }

    public Long delete(Long id) {
        this.newsRespository.deleteById(id);
        return id;
    }
}