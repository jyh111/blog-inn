package com.example.blog.controller;

import com.example.blog.bl.BlogService;
import com.example.blog.bl.FavorService;
import com.example.blog.vo.FavorVO;
import com.example.blog.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/favors")
public class FavorController {

    @Autowired
    FavorService favorService;

    @Autowired
    BlogService blogService;

    @PostMapping("/putFavor")
    public ResponseVO putFavor(@RequestBody FavorVO favorVO){
        return favorService.putFavor(favorVO);
    }

    @GetMapping("/{userId}/getFavor")
    public ResponseVO getFavorsByUserId(@PathVariable Integer userId){
        return ResponseVO.buildFailure("");
    }
}
