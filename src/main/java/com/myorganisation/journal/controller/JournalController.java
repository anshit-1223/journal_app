package com.myorganisation.journal.controller;

import com.myorganisation.journal.model.JournalModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalController {

    private Map<Long,JournalModel> journalModelMap = new HashMap<>();

    @GetMapping("/all")
    public List<JournalModel> getAllJournal(){
        
        return new ArrayList<>(journalModelMap.values());
    }

    @PostMapping
    public List<JournalModel> createJournal(@RequestBody JournalModel journalModel){
        journalModelMap.put(journalModel.getId(),journalModel);
        return new ArrayList<>(journalModelMap.values());
    }
}
