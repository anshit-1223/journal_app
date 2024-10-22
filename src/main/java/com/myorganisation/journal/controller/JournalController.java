package com.myorganisation.journal.controller;

import com.myorganisation.journal.model.JournalModel;
import com.myorganisation.journal.service.JournalService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


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
    public JournalModel getJournalModelById(@PathVariable ObjectId id){
        return journalService.getEntryById(String.valueOf(id)).orElse(null);
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
