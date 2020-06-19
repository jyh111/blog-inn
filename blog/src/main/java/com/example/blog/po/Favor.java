package com.example.blog.po;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Favor {
    private Integer userId;
    private Integer blogId;
    private String classification;
}
