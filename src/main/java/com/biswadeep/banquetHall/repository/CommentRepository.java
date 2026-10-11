package com.biswadeep.banquetHall.repository;

import com.biswadeep.banquetHall.entity.CommentModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<CommentModel, String> {
}
