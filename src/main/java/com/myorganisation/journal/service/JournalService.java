package com.myorganisation.journal.service;

import com.myorganisation.journal.model.JournalModel;
import com.myorganisation.journal.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;

    public void saveEntry(JournalModel journalModel){
        journalRepository.save(journalModel);
    }

    public List<JournalModel> getAllEntry(){
        return journalRepository.findAll();
    }
}
