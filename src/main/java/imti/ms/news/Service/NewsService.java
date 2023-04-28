package imti.ms.news.Service;
import imti.ms.news.Model.News;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface NewsService {
    
    List<News> getNews();

    News getNewsById(Long id);

    News addNews(News n);

    void updateNews(Long id, News n);

    void deleteNews(Long id);
}
