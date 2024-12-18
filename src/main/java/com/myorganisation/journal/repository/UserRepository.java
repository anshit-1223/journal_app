package com.myorganisation.journal.repository;

import com.myorganisation.journal.model.UserModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserModel, ObjectId> {
}
