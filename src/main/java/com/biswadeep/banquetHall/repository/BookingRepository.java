package com.biswadeep.banquetHall.repository;

import com.biswadeep.banquetHall.entity.BookingModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends MongoRepository<BookingModel, String> {
    public void deleteByEmail(String email);
    public boolean existsByEmail(String email);
}
