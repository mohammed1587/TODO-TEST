package com.touab.todoback;

import com.touab.todoback.Entity.TODO;
import com.touab.todoback.infra.TODORepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoBackApplication.class, args);
    }

    @Bean
    CommandLineRunner start(TODORepository todoRepository) {
        return args -> {
            todoRepository.save(new TODO(null, "Install NodeJS", "Install NodeJS and Create new Angular app", false));
            todoRepository.save(new TODO(null, "Create new java project", "Create new spring boot java application", false));
            todoRepository.save(new TODO(null, "Rest Api", "Create the *rest Controller", false));
            todoRepository.save(new TODO(null, "UI", "Create list of TODO", true));

        };
    }
}

