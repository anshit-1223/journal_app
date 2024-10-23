package com.myorganisation.journal.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "journal_entries")
@Data
public class JournalModel {

    @Id
    private String id;
    private String title;
    private String description;
    private LocalDateTime dateTime;
}
