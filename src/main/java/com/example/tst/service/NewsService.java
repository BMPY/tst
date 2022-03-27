package com.example.tst.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.example.tst.entity.NewsEntity;
import com.example.tst.entity.TypeEntity;
import com.example.tst.exception.NotFoundNewsException;
import com.example.tst.model.News;
import com.example.tst.model.NewsForType;
import com.example.tst.respository.NewsRespository;
import com.example.tst.respository.TypeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
    @Autowired
    private NewsRespository newsRespository;
    @Autowired
    private TypeRespository typeRespository;

    public NewsService() {
    }

    public News post(NewsEntity news, Long typeId) {
        TypeEntity type = (TypeEntity)this.typeRespository.findById(typeId).get();
        news.setType(type);
        return News.toModel((NewsEntity)this.newsRespository.save(news));
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

    public List<NewsForType> getNews(Long typeId) throws NotFoundNewsException {
        TypeEntity type = (TypeEntity)this.typeRespository.findById(typeId).get();
        List<NewsForType> list = type.getNews().stream().map(NewsForType::toModel).collect(Collectors.toList());
        if (type == null) {
            throw new NotFoundNewsException("Not found the news by type");
        } else {
            return list;
        }
    }

    public Long delete(Long id) {
        this.newsRespository.deleteById(id);
        return id;
    }
}