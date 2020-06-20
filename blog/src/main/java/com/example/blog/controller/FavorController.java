package com.example.blog.controller;

import com.example.blog.bl.FavorService;
import com.example.blog.vo.BlogInfoVO;
import com.example.blog.vo.FavorVO;
import com.example.blog.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/favors")
public class FavorController {

    @Autowired
    FavorService favorService;

    @PostMapping("/putFavor")
    public ResponseVO putFavor(@RequestBody FavorVO favorVO){
        return favorService.putFavor(favorVO);
    }

    @GetMapping("/{userId}/getFavor")
    public ResponseVO getFavors(@RequestParam String classification,@PathVariable Integer userId){
        List<BlogInfoVO> blogInfoVOS=favorService.getFavors(userId,classification);
        if(blogInfoVOS==null){
            return ResponseVO.buildFailure("");
        }
        return null;
    }

}
