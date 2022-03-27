package com.example.tst.controller;

import com.example.tst.entity.NewsEntity;
import com.example.tst.model.NewsCreate;
import com.example.tst.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/news"})
public class NewsController {

    private NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping
    public ResponseEntity createNews(@RequestBody NewsCreate news) { // запихнуть
        try {
            return ResponseEntity.ok(this.newsService.post(news));
        } catch (Exception var4) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping
    public ResponseEntity getNews(@RequestParam(required = false) Long id) {
        try {
            if(id == null)
                return ResponseEntity.ok(this.newsService.getAllNews());

            return ResponseEntity.ok(this.newsService.getOneNews(id));
        } catch (Exception var2) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(this.newsService.delete(id));
        } catch (Exception var3) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}