package com.MUL.controller;

import com.MUL.entity.Answer;
import com.MUL.entity.ListeningTest;
import com.MUL.entity.Question;
import com.MUL.entity.Test;
import com.MUL.service.ListeningTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("listening-test")
public class ListeningTestController {
    @Autowired
    ListeningTestService listeningTestService;

    @GetMapping(path = "/get-all")
    public List<ListeningTest> getAllListeningTests(){
        return listeningTestService.getAll();
    }

    @PostMapping(path = "/create")
    public String insertNewListeningTest(@RequestBody ListeningTest listeningTest){
    System.out.println(listeningTest);
        listeningTestService.save(listeningTest);

        //listeningTestService.addNewListeningTest();
        return "Insert finished";

    }
    @GetMapping(path="/get-by-id/{id}")
    public ListeningTest getListeningTestById(@PathVariable(name= "id")Long id){
        return listeningTestService.findById(id);

    }

    @PutMapping(path="/update")
    public String updateListeningTest(@RequestBody ListeningTest listeningTest){
       listeningTestService.update(listeningTest);

        return "Update finished";
    }

    @DeleteMapping(path = "/delete-by-id/{id}")
    public String deleteListeningTest(@PathVariable(name = "id") Long id){
        listeningTestService.deleteById(id);
        return "delete success !";

    }



}
