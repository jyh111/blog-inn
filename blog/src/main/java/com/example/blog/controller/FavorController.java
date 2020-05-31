package com.example.blog.controller;

import com.example.blog.vo.ResponseVO;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/favors")
public class FavorController {

    @PostMapping("/{userID}/putFavor")
    public ResponseVO putFavor(@PathVariable int userID){
        return ResponseVO.buildFailure("");
    }

    @GetMapping("/{userID}/getFavor")
    public ResponseVO getFavorsByUserID(@PathVariable int userID){
        return ResponseVO.buildFailure("");
    }
}
