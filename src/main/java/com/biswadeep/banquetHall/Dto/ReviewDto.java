package com.biswadeep.banquetHall.Dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewDto {
    private String id;
    private long seq;
    private String name;
    private String video;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
