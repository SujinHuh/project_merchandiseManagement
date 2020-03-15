package jpabook.merchandiseManagement;

import jpabook.merchandiseManagement.domain.Board;
import jpabook.merchandiseManagement.repository.BoardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public CommandLineRunner runner(BoardRepository boardRepository) throws Exception {
		return (args) -> {
			IntStream.rangeClosed(1, 100).forEach(index ->
					boardRepository.save(Board.builder()
							.title("게시글" + index)
							.content("내용" + index)
							.createdDate(LocalDateTime.now())
							.updatedDate(LocalDateTime.now()).build()));
		};
	}

}
