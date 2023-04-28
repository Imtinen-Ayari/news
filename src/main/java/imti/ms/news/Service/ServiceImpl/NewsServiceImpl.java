package imti.ms.news.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import imti.ms.news.Model.News;
import imti.ms.news.Repository.NewsRepository;
import imti.ms.news.Service.NewsService;



@Service
public class NewsServiceImpl implements NewsService {
    NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }


    @Override
    public List<News> getNews() {
         List<News> n = new ArrayList<>();
         newsRepository.findAll().forEach(n::add);
         return n ;
    }

    @Override
    public News getNewsById(Long id) {
        return newsRepository.findById(id).get();

    }

    @Override
    public News addNews(News n) {
        return newsRepository.save(n);

    }

    @Override
    public void updateNews(Long id, News n) {
         newsRepository.save(n);

    }

    @Override
    public void deleteNews(Long id) {
        newsRepository.deleteById(id);

    }

  
   

}
