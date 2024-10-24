package com.myorganisation.journal.controller;

import com.myorganisation.journal.model.JournalModel;
import com.myorganisation.journal.service.JournalService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalService journalService;

    @GetMapping
    public List<JournalModel> getAllJournal(){
     return journalService.getAllEntry();
    }

    @PostMapping
    public JournalModel createJournal(@RequestBody JournalModel journalModel){
        journalModel.setDateTime(LocalDateTime.now());
        return journalService.saveEntry(journalModel);
    }

    @GetMapping("{id}")
    public ResponseEntity<JournalModel> getJournalModelById(@PathVariable ObjectId id){
        Optional<JournalModel> journalModel= journalService.getEntryById(String.valueOf(id));
        if(journalModel.isPresent()){
            return new ResponseEntity<>(journalModel.get(), HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public JournalModel deleteJournalModelById(@PathVariable ObjectId id){
        journalService.deleteEntry(String.valueOf(id));
        return null;
    }

    @PutMapping("{id}")
    public JournalModel updateJournalModelById(@PathVariable ObjectId id, @RequestBody JournalModel journalModel){
        JournalModel old =journalService.getEntryById(String.valueOf(id)).orElse(null);
        if(old!= null){
            old.setTitle(journalModel.getTitle()!= null && !journalModel.getTitle().equals("")? journalModel.getTitle() : old.getTitle());
            if(journalModel.getDescription()!= null && !journalModel.getDescription().equals("")){
                journalModel.getDescription();
            }
            else{
                old.getDescription();
            }
        }
        journalService.saveEntry(old);
        return old;
    }
}
