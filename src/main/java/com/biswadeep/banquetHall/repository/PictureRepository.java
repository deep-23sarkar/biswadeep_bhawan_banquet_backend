package com.biswadeep.banquetHall.repository;

import com.biswadeep.banquetHall.entity.PostPictureModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends MongoRepository<PostPictureModel, String> {
}
