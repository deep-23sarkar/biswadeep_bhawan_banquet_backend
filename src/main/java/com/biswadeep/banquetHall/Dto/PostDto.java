package com.biswadeep.banquetHall.Dto;

import com.biswadeep.banquetHall.entity.CATEGORIES;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDto {
    private String id;
    private Long seq;
    private String image;
    private CATEGORIES category;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
