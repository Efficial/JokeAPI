package francis.emmanuel.jokeAPI;

import francis.emmanuel.jokeAPI.domain.jokes.models.Joke;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class JokeApiApplication {

	private static final Logger logger = LoggerFactory.getLogger(JokeApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JokeApiApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Joke joke = restTemplate.getForObject(
					"https://yomomma-api.herokuapp.com/jokes", Joke.class);
			logger.info(joke.toString());
		};
	}
}
