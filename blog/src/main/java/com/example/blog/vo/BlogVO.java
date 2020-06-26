package com.example.blog.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogVO {
    private Integer blogId;
    private Integer writerId;
    //"null"表示没有收藏，""表示收藏后没有手动添加别的分类，"自定义类别"表示收藏后添加到了自定义的收藏夹里
    private String inFavor="";
    private Integer page_view;
    private String content;
    private String title;
    private String classification;

    public String toString(){
        return "blogId: "+blogId+"/n"+
                "writerId: "+writerId+"/n"+
                "inFavor "+inFavor+"/n"+
                "page_view "+page_view+"/n"+
                "classification"+classification+"/n"+
                "title: "+title+"/n"+
                "content: "+content;
    }
}
