package imti.ms.news;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import imti.ms.news.Model.News;
import imti.ms.news.Repository.NewsRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class NewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsApplication.class, args);
	}
 
	@Bean
	ApplicationRunner start(NewsRepository newsRepository)
	{ 
			return  args -> {
				Stream.of(new News(null, "Team-News","Erik ten Hag has confirmed that Alejandro Garnacho has returned to training with his team-mates, as Manchester United get set for Sunday's Premier League game against Aston Villa."))
				.forEach(n -> 
					{
						newsRepository.save(n);
					}					    );
					newsRepository.findAll().forEach(n->System.out.println(n.getId()));
			
	};
	
	}
}
