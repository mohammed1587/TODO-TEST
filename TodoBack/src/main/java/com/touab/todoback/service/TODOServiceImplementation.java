package com.touab.todoback.service;


import com.touab.todoback.Entity.TODO;
import com.touab.todoback.infra.TODORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Transactional
@Service
public class TODOServiceImplementation implements TODOService {


    @Autowired
    private TODORepository todoRepository;

    @Override
    public List<TODO> getAllTODO() {
        return todoRepository.findAll();
    }

    @Override
    public void saveTODO(TODO todo) {
          todoRepository.save(todo);
    }

    @Override
    public TODO getTODO(Long id) {
        Optional<TODO> todo = todoRepository.findById(id);
        if(todo.isPresent())
            return todo.get();
        return null;
    }

    @Override
    public void changStatus(Long id) {
        Optional<TODO> todo = todoRepository.findById(id);
        if(todo.isPresent()){
            todo.get().setDone(!todo.get().getDone());
    }}

    @Override
    public List<TODO> findTodoByDone(Boolean done) {
        return todoRepository.findByDone(done);
    }
}
