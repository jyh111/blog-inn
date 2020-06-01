package com.example.blog.controller;

import com.example.blog.bl.FavorService;
import com.example.blog.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/favors")
public class FavorController {

    @Autowired
    FavorService favorService;

    @GetMapping("/putFavor")
    public ResponseVO putFavor(@RequestParam String classification,@RequestParam int blogId){
        return ResponseVO.buildFailure("");
    }

    @GetMapping("/{userID}/getFavor")
    public ResponseVO getFavorsByUserID(@PathVariable int userID){
        return ResponseVO.buildFailure("");
    }
}
