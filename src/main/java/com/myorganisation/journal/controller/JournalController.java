package com.myorganisation.journal.controller;

import com.myorganisation.journal.model.JournalModel;
import com.myorganisation.journal.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalService journalService;

    @GetMapping
    public String getAllJournal(){
     journalService.getAllEntry();
    return "Fetched";
    }

    @PostMapping
    public String createJournal(@RequestBody JournalModel journalModel){
        journalService.saveEntry(journalModel);
        return "Created";
    }

    @GetMapping("{id}")
    public JournalModel getJournalModelById(@PathVariable Long id){
        return null;
    }

    @DeleteMapping("{id}")
    public JournalModel deleteJournalModelById(@PathVariable Long id){
        return null;
    }

    @PutMapping("{id}")
    public JournalModel updateJournalModelById(@PathVariable Long id, @RequestBody JournalModel journalModel){
        return null;
    }
}
