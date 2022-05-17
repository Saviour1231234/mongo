package com.example.mongodbproject;

import com.example.mongodbproject.entity.User;
import com.example.mongodbproject.repository.UserRepository;
import com.example.mongodbproject.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MongoDbProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoDbProjectApplication.class, args);
    }


//    UserService userService;
//    MongoTemplate mongoTemplate;
//    UserRepository userRepository;

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//
//            mongoTemplate.insertAll(List.of(
//                    new User(1L,"Igor", "Bobrenok", 34),
//                    new User(2L,"Igor", "Bobrenok", 34),
//                    new User(3L,"Igor", "Bobrenok", 34),
//                    new User(4L,"Igor", "Bobrenok", 34),
//                    new User(5L,"Igor", "Bobrenok", 34),
//                    new User(6L,"Igor", "Bobrenok", 34),
//                    new User(7L,"Igor", "Bobrenok", 34),
//                    new User(8L,"Igor", "Bobrenok", 34),
//                    new User(9L,"Igor", "Bobrenok", 34)
//            ));
//
//            var all = userService.findAll();
//
//            System.out.println(all);
//
//            System.out.println(userService.findById(1L));
//
//            var allByName = userRepository.findAllByName("Igor");
//            System.out.println(allByName);
//
//
//        };
//    }
}
