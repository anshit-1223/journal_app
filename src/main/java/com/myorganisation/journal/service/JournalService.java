package com.myorganisation.journal.service;

import com.myorganisation.journal.model.JournalModel;
import com.myorganisation.journal.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    public Optional<JournalModel> getEntryById(String MyId){
        return journalRepository.findById(MyId);
    }
    public void deleteEntry(String MyId){
        journalRepository.deleteById(MyId);

    }

    public JournalModel updateEntry(String MyId,JournalModel journalModel){

    }
}
