package com.SpringBoot.project2.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPostDto {
    private Long postId;
    private Long userId;
    private String post;
}
