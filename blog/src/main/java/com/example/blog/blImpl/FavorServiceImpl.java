package com.example.blog.blImpl;

import com.example.blog.bl.FavorService;
import com.example.blog.data.FavorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavorServiceImpl implements FavorService {

    @Autowired
    FavorMapper favorMapper;

}
