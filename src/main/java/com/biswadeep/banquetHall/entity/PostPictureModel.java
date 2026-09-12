package com.biswadeep.banquetHall.entity;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document(collection = "postPictures")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostPictureModel {
//    @Id
    private String id;

    private Long seq;

    private String image;

//    @Enumerated(EnumType.STRING)
    private CATEGORIES category;

    private String title;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
