package com.biswadeep.banquetHall.Dto;

import com.biswadeep.banquetHall.entity.CATEGORIES;
import lombok.Data;

@Data
public class RequestPostDto {
    private String image;
    private CATEGORIES category;
    private String title;
}
