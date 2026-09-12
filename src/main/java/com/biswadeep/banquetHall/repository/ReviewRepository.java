package com.biswadeep.banquetHall.repository;

import com.biswadeep.banquetHall.entity.ReviewModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<ReviewModel,String> {
}
