package com.touab.todoback.infra;

import com.touab.todoback.Entity.TODO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TODORepository extends JpaRepository<TODO, Long> {

    public List<TODO> findByDone(boolean done);

}
