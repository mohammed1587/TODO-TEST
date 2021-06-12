package com.touab.todoback;

import com.github.javafaker.Faker;
import com.touab.todoback.Entity.TODO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TodoServiceIntegrationTest {


    @Autowired
    private TestRestTemplate testRestTemplate;

    private TODO getRandomTodo() {
        Faker faker = new Faker();
        return new TODO(null, faker.pokemon().name(), faker.job().position(), faker.random().nextBoolean());
    }

    @Test
    public void AddNewTodoCase() {
        HttpEntity<TODO> entity = new HttpEntity<>(getRandomTodo());
        ResponseEntity<String> response = testRestTemplate.postForEntity("/todo/newTodo", entity, null);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void getTodoByIDCase() {
        ResponseEntity<TODO> response = testRestTemplate.getForEntity("/todo/getTodoDetails/1", TODO.class);
        TODO todo = response.getBody();
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(todo);
        assertEquals("1", todo.getId().toString());
    }


    @Test
    public void getAlTodoCase() {
        ResponseEntity<TODO[]> response = testRestTemplate.getForEntity("/todo/getAllTodo", TODO[].class);
        List<TODO> lst = Arrays.asList(response.getBody());
        assertThat(response.getStatusCode(), equalTo((HttpStatus.OK)));
        assertThat(lst, notNullValue());
        assertNotEquals(0, lst.size());
    }

    @Test
    public void updateTodoCase() {
        ResponseEntity<TODO[]> response = testRestTemplate.getForEntity("/todo/changeTodoStatus/1", TODO[].class);
        List<TODO> lst = Arrays.asList(response.getBody());
        assertThat(response.getStatusCode(), equalTo((HttpStatus.OK)));
        assertThat(lst, notNullValue());
        assertNotEquals(0, lst.size());
    }

}
