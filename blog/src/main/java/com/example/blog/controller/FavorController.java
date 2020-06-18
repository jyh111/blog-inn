package com.example.blog.controller;

import com.example.blog.bl.BlogService;
import com.example.blog.bl.FavorService;
import com.example.blog.vo.FavorFolderVO;
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

    @PostMapping("/{userId}/putFavorFolder")
    public ResponseVO putFavorFolder(@RequestBody FavorFolderVO favorFolderVO, @PathVariable Integer userId){
        return favorService.putFavorFolder(userId,favorFolderVO.getFolder_name());
    }

    @GetMapping("/{userId}/deleteFavorFolder")
    public ResponseVO deleteFavorFolder(@RequestParam String folder_name,@PathVariable Integer userId){
        return favorService.deleteFavorFolder(userId,folder_name);
    }

}
