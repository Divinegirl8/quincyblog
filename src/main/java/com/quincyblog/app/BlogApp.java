package com.quincyblog.app;

import com.quincyblog.data.model.Blog;
import com.quincyblog.data.model.Comment;
import com.quincyblog.data.repositories.BlogRepository;
import com.quincyblog.data.repositories.CommentRepository;
import com.quincyblog.dtos.request.BlogPostRequest;
import com.quincyblog.dtos.request.DeleteBlogCommentRequest;
import com.quincyblog.dtos.request.EditBlogImageRequest;
import com.quincyblog.dtos.request.EditBlogRequest;
import com.quincyblog.exceptions.BlogPostException;
import com.quincyblog.service.BlogService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static com.quincyblog.util.NumberEncoder.numberEncoder;
import static com.quincyblog.util.Validation.validateBlog;
import static com.quincyblog.util.Validation.validateEditBlog;

@Service
public class BlogApp implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Value("${post.number}")
    private int POST_NUMBER;
    @Autowired
    private CloudinaryApp cloudinaryApp;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void post(BlogPostRequest request, MultipartFile multipartFile) throws BlogPostException, IOException {
        validateBlog(request,multipartFile);
        validatePostNumber(request.getPostNumber());
        String number = numberEncoder(request.getPostNumber());



        String imageUrl = cloudinaryApp.uploadImage(multipartFile).getUrl();


        Blog blog = Blog.builder()
                .description(request.getDescription())
                .url(imageUrl)
                .postNumber(number)
                .build();

        blogRepository.save(blog);

    }

    @Override
    public List<Blog> getAllPost() {
        return blogRepository.findAll();
    }

    @Override
    public void deleteBlog(Long id) throws BlogPostException {
      Blog blogId = blogRepository.findById(id).orElseThrow(()-> new BlogPostException("Blog post not found"));

      blogRepository.deleteById(blogId.getId());
    }

    @Override
    public void deleteAllBlog() {
        blogRepository.deleteAll();

    }

    @Override
    public void editBlog(EditBlogRequest editBlogRequest) throws BlogPostException, IOException {
        validatePostNumber(editBlogRequest.getPostNumber());
        validateEditBlog(editBlogRequest);

        String number = numberEncoder(editBlogRequest.getPostNumber());

        Blog blog = blogRepository.findById(editBlogRequest.getId()).orElseThrow(() -> new BlogPostException("Blog post not found"));

        if (blog.getDescription() != null){
            blog.setDescription(editBlogRequest.getDescription());
        }


        if (blog.getPostNumber() != null){
            blog.setPostNumber(number);
        }

        blogRepository.save(blog);
    }

    @Override
    public void editBlogImage(MultipartFile multipartFile,Long id) throws IOException, BlogPostException {
        String imageUrl = cloudinaryApp.uploadImage(multipartFile).getUrl();

        Blog blog = blogRepository.findById(id).orElseThrow(() -> new BlogPostException("Blog post not found"));

        if (blog.getUrl() != null){
        blog.setUrl(imageUrl);}

        blogRepository.save(blog);

    }



    private void validatePostNumber(String number) throws BlogPostException {

        if (Integer.parseInt(number) != POST_NUMBER){
            throw new BlogPostException("post number is not correct");
        }

    }
}
