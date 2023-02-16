package com.telusko.joblisting.controller;

import com.telusko.joblisting.model.Post;
import com.telusko.joblisting.repository.PostRepository;
import com.telusko.joblisting.repository.SearchRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepositoryImp srepo;
    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendRedirect("/swagger-ui.html");
    }
    @GetMapping(value = "/getAllPosts")
    public List<Post> getAllPost(){
        return repo.findAll();
    }
    @PostMapping(value = "/post")
    public Post addPost(@RequestBody Post post){
        return repo.save(post);
    }

    @GetMapping(value = "/posts/{text}")
    public List<Post> search(@PathVariable("text") String text){
        return srepo.findByText(text);
    }

}
