package com.SpringBoot.project2.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Integer postId;
    private Integer userId;
    private String post;
}
