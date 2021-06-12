package com.touab.todoback.controller;


import com.touab.todoback.Entity.TODO;
import com.touab.todoback.exception.InvalidData;
import com.touab.todoback.service.TODOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/todo")
@CrossOrigin(origins = "*")

public class TODOController {

    @Autowired
    private TODOService todoService;

    @GetMapping("/getAllTodo")
    public List<TODO> getAllTODO() {
        return todoListTri();
    }

    @GetMapping("/getTodoDetails/{id}")
    public TODO getTODODetails(@PathVariable Long id) {

        return todoService.getTODO(id);
    }

    @GetMapping("/changeTodoStatus/{id}")
    public List<TODO> changeTodoStatus(@PathVariable Long id) {
        todoService.changStatus(id);
        return todoListTri();
    }


    private List<TODO> todoListTri() {
        List<TODO> undone = todoService.findTodoByDone(false);
        Collections.reverse(undone);
        List<TODO> done = todoService.findTodoByDone(true);

        return Stream.of(undone, done)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

    }

    @PostMapping(value = "/newTodo")
    public void saveTodo(@RequestBody TODO todo) throws InvalidData {
        if (todo.getName().isEmpty())
            throw new InvalidData("This field should not be empty", "Name");
        todoService.saveTODO(todo);
    }

}
