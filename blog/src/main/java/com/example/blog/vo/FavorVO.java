package com.example.blog.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavorVO {
    private Integer userId;
    private Integer blogId;
    private String classification;
}
