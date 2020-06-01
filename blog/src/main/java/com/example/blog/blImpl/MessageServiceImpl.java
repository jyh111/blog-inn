package com.example.blog.blImpl;

import com.example.blog.bl.MessageService;
import com.example.blog.data.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;

}
