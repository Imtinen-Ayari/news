package imti.ms.news.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import imti.ms.news.Model.News;
import imti.ms.news.Service.NewsService;

@RestController
@RequestMapping("/News")

public class NewsController {
    NewsService newsService;

    public  NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public ResponseEntity<List<News>> getNews() {
        List<News> List_News = newsService.getNews();
        return new ResponseEntity<>(List_News, HttpStatus.OK);
    }

    @GetMapping({"/{Id}"})
    public ResponseEntity<News> getNews(@PathVariable Long Id) {
        return new ResponseEntity<>(newsService.getNewsById(Id), HttpStatus.OK);
    }

    public ResponseEntity<News> saveNews(@RequestBody News News) {
        News News1 = newsService.addNews(News);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(News1, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{Id}"})
    public ResponseEntity<News> updateNews(@PathVariable("Id") Long Id, @RequestBody News News) {
        newsService.updateNews(Id, News);
        return new ResponseEntity<>(newsService.getNewsById(Id), HttpStatus.OK);
    }
 
    @DeleteMapping({"/{Id}"})
    public ResponseEntity<News> deleteNews(@PathVariable("Id") Long Id) {
        newsService.deleteNews(Id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
