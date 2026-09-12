package com.biswadeep.banquetHall.Dto;

//import jakarta.persistence.Id;
import lombok.Data;
//import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
public class ResponseBook {
    private String id;

    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String message;

    private LocalDateTime createdAt;
}
