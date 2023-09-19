package dev.samiksha.productService;


import dev.samiksha.productService.InheritanceDemo.SingleTabl.Mentor;
import dev.samiksha.productService.InheritanceDemo.SingleTabl.MentorRepository;
import dev.samiksha.productService.InheritanceDemo.SingleTabl.User;
import dev.samiksha.productService.InheritanceDemo.SingleTabl.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	/*private UserRepository userRepository;
	private MentorRepository mentorRepository;

	ProductServiceApplication(@Qualifier("st_user_repository") UserRepository userRepository,
							  @Qualifier("st_mentor_repository") MentorRepository mentorRepository) {
		this.userRepository = userRepository;
		this.mentorRepository = mentorRepository;
	}



	@Override
	public void run(String... args) throws Exception {

		User user = new User();
		user.setName("Samiksha");
		user.setEmail("samiksha@gmail.com");
		userRepository.save(user);

		Mentor mentor = new Mentor();
		mentor.setName("Samiksha");
		mentor.setAverageRating(4.5);
		mentor.setEmail("samiksha@gmail.com");
		mentorRepository.save(mentor);
	}*/

}
