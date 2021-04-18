package com.allo.hrworker.resources;

import com.allo.hrworker.entities.Worker;
import com.allo.hrworker.repositories.WorkRepository;
import lombok.AllArgsConstructor;
import org.hibernate.jdbc.Work;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
@AllArgsConstructor
public class WorkerResource {

    private static Logger log = LoggerFactory.getLogger(WorkerResource.class);

    private final Environment env;

    private final WorkRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        log.info("Port = " + env.getProperty("local.server.port"));

        Worker worker = repository.findById(id).orElseThrow();
        return ResponseEntity.ok(worker);
    }
}
