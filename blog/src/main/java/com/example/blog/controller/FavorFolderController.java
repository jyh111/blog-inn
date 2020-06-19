package com.example.blog.controller;

import com.example.blog.bl.FavorFolderService;
import com.example.blog.vo.FavorFolderVO;
import com.example.blog.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/favorFolders")
public class FavorFolderController {

    @Autowired
    FavorFolderService favorFolderService;

    @GetMapping("/{userId}/getFavorFolders")
    public ResponseVO getFavorFoldersByUserId(@PathVariable Integer userId){
       return ResponseVO.buildSuccess(favorFolderService.getFavorFoldersByUserId(userId));
    }

    @PostMapping("/{userId}/putFavorFolder")
    public ResponseVO putFavorFolder(@RequestBody FavorFolderVO favorFolderVO, @PathVariable Integer userId){
        return favorFolderService.putFavorFolder(userId,favorFolderVO.getFolder_name());
    }

    @GetMapping("/{userId}/deleteFavorFolder")
    public ResponseVO deleteFavorFolder(@RequestParam String folder_name,@PathVariable Integer userId){
        return favorFolderService.deleteFavorFolder(userId,folder_name);
    }
}
