package com.telusko.joblisting.repository;

import com.telusko.joblisting.model.Post;

import java.util.List;

public interface SearchRepositary {
    List<Post> findByText(String text);
}
