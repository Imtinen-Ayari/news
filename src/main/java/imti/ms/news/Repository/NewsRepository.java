package imti.ms.news.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import imti.ms.news.Model.News;

@Repository
public interface NewsRepository extends  JpaRepository<News,Long> {
    
}
