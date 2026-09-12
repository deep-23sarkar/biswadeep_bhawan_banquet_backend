package com.biswadeep.banquetHall.entity;

//import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "bookings")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingModel {
//    @Id
    private String id;

    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String message;

    @CreatedDate
    private LocalDateTime createdAt;
}
