package com.quincyblog.data.repositories;

import com.quincyblog.data.model.Blog;
import com.quincyblog.data.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Long> {


}
