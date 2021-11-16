package com.MUL.controller;

import com.MUL.entity.ListeningTest;
import com.MUL.entity.ReadingTest;
import com.MUL.service.ReadingTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reading-test")
public class ReadingTestController {
    @Autowired
   private ReadingTestService readingTestService;

    @GetMapping(path = "/get-all")
    public List<ReadingTest> getAllReadingTest(){
        return readingTestService.getAll();
    }

    @PostMapping(path = "/create")
    public String insertNewReadingTest(@RequestBody ReadingTest readingTest){
        System.out.println(readingTest);
        readingTestService.save(readingTest);

        return "insert successfull !";
    }

    @GetMapping(path = "/get-by-id/{id}")
    public ReadingTest getReadingTestById(@PathVariable(name = "id") Long id){
        return readingTestService.findById(id);
    }

    @PutMapping(path="/update")
    public String updateReadingTest(@RequestBody ReadingTest readingTest){
        readingTestService.update(readingTest);
        return "update successfully !";

    }
    @DeleteMapping(path = "/delete-by-id/{id}")
    public String deleteListeningTestById(@PathVariable(name = "id") Long id){
        readingTestService.deleteById(id);
        return "delete successfully !";
    }
    @GetMapping("/find-by-keyword/{keyword}")
    public List<ReadingTest> findByKeyword(@PathVariable(name="keyword") String keyword){
        return readingTestService.findByKeyword(keyword);

    }

}
