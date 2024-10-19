package com.myorganisation.journal.repository;

import com.myorganisation.journal.model.JournalModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalRepository extends MongoRepository<JournalModel, String> {
}
