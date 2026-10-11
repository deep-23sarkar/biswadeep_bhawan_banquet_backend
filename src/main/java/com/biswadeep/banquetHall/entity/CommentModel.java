package com.biswadeep.banquetHall.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "comments")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentModel {
    private String id;
    private String name;
    private String text;

    @CreatedDate
    private LocalDateTime createdAt;
}
