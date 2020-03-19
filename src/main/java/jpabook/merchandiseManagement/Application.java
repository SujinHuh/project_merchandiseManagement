package jpabook.merchandiseManagement;

import jpabook.merchandiseManagement.domain.Board;
import jpabook.merchandiseManagement.repository.BoardRepository;
import jpabook.merchandiseManagement.service.BoardService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@EnableJpaAuditing
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner runner(BoardService boardService) throws Exception {
		return (args) -> {
			IntStream.rangeClosed(1, 100).forEach(index ->
					boardService.registerBoard(Board.builder()
							.title("게시글" + index)
							.content("내용" + index)
							.createdDate(LocalDateTime.now())
							.updatedDate(LocalDateTime.now()).build()));
		};
	}
}

