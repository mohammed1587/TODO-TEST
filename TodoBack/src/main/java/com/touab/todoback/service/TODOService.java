package com.touab.todoback.service;

import com.touab.todoback.Entity.TODO;

import java.util.List;

public interface TODOService {

    public List<TODO> getAllTODO();
    public void saveTODO(TODO todo);
    public TODO getTODO(Long id);
    public void changStatus(Long id);
    public List<TODO> findTodoByDone(Boolean done);


}
