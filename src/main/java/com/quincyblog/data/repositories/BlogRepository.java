package com.quincyblog.data.repositories;

import com.quincyblog.data.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,Long> {
}
