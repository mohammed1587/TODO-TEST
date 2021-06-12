package com.touab.todoback;


import com.github.javafaker.Faker;
import com.touab.todoback.Entity.TODO;
import com.touab.todoback.infra.TODORepository;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@FixMethodOrder(MethodSorters.DEFAULT)
public class TodoServiceRepositoryMockTest {


    @Autowired
    private TODORepository repository;


    @Before
    public void dataSeedForTest() {

        Faker faker = new Faker();
        for (int i = 0; i < 5; i++) {
            TODO todo = new TODO(null, faker.book().author(), faker.gameOfThrones().quote(), faker.random().nextBoolean());
            repository.save(todo);
        }
    }

    @Test
    public void todoListSize() {
        List<TODO> lst = repository.findAll();
        assertEquals(lst.size(), 9);
    }

    @Test
    public void addBookTestAnd() {
        TODO todo = new TODO(null, "Todo 1", "Installer NodeJs", false);
        TODO savedTodo = repository.save(todo);
        assertNotNull(savedTodo);
        assertEquals(savedTodo.getName(), "Todo 1");
        Optional<TODO> todoReturn = repository.findById(savedTodo.getId());
        todoReturn.orElse(null);
        todo = todoReturn.get();
        assertNotNull(todo);
        assertEquals(todo.getDescription(), "Installer NodeJs");
    }


}
