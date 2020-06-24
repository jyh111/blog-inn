package com.example.blog.ControllerTest;

import com.example.blog.TestAPI;
import com.example.blog.vo.BlogVO;
import com.example.blog.vo.ResponseVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class BlogControllerTest extends TestAPI {

    private static final String blogAPI="/api/blogs";

    private MvcResult getBlogByBlogIdAPI(int blogId,int userId) throws Exception {
        RequestBuilder builder=MockMvcRequestBuilders
                .get(blogAPI+"/{blogId}/detail",blogId)
                .param("userId",Integer.toString(userId))
                .accept(MediaType.APPLICATION_JSON_UTF8);
        return mockMvc.perform(builder).andReturn();
    }

    /**
     * getBlogByBlogId Tests
     */
    @Test
    public void TestGetBlogById_1() throws Exception {
        ResponseVO responseVO=getResult(getBlogByBlogIdAPI(1,1));
        Assert.assertFalse(responseVO.getSuccess());
        Assert.assertEquals("文章不存在",responseVO.getMessage());
    }





}
