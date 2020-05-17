package com.example.blog.vo;

import java.util.ArrayList;


/**
 * @Author: hou rui
 * @Date: 2020-05-16
 */
public class BlogVO {
    private UserInfoVO writer;
    private ArrayList<CommentVO> comment_list;
    private boolean is_in_favor;
    private int page_view;

    public UserInfoVO getWriter() {
        return writer;
    }

    public void setWriter(UserInfoVO writer) {
        this.writer = writer;
    }

    public ArrayList<CommentVO> getComment_list() {
        return comment_list;
    }

    public void setComment_list(ArrayList<CommentVO> comment_list) {
        this.comment_list = comment_list;
    }

    public boolean getIs_in_favor(){
        return is_in_favor;
    }

    public void setIs_in_favor(boolean is_in_favor) {
        this.is_in_favor = is_in_favor;
    }

    public int getPage_view() {
        return page_view;
    }

    public void setPage_view(int page_view) {
        this.page_view = page_view;
    }
}
