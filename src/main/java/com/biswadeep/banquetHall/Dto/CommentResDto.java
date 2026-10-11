package com.biswadeep.banquetHall.Dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentResDto {
    private String id;
    private String name;
    private String text;
    private LocalDateTime createdAt;
}
