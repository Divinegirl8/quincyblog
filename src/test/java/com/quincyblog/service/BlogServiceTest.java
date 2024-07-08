package com.quincyblog.service;

import com.quincyblog.data.model.Blog;
import com.quincyblog.dtos.request.BlogPostRequest;
import com.quincyblog.dtos.request.DeleteBlogCommentRequest;
import com.quincyblog.dtos.request.EditBlogRequest;
import com.quincyblog.exceptions.BlogPostException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BlogServiceTest {
    @Autowired
    private BlogService blogService;

    @Test void testThatABlogCanBePosted() throws IOException, BlogPostException {

        File file = new File("/home/user/Pictures/blog.jpeg");
        FileInputStream inputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("filename",inputStream);

        BlogPostRequest blogPostRequest = new BlogPostRequest();
        blogPostRequest.setPostNumber("2990");
        blogPostRequest.setDescription("A blog about fancy life");


        blogService.post(blogPostRequest,multipartFile);

    }

    @Test void testThatABlogCanBePosted2() throws IOException, BlogPostException {

        File file = new File("/home/user/Pictures/blog.jpeg");
        FileInputStream inputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("filename",inputStream);

        BlogPostRequest blogPostRequest = new BlogPostRequest();
        blogPostRequest.setPostNumber("2990");
        blogPostRequest.setDescription("""
                The night Obi moved into his new flat, something came for him. He was lounging on the sofa when the knock jarred him.
                                
                "Who is there?" he asked, springing to his feet.
                                
                A bright flash of lightning lit the sitting room, and thunder rumbled as if the skies were setting a wild beast loose.
                                
                "Who is there?" he asked again, but no one answered.
                                
                Then he ambled to the door and listened. Footsteps were echoing, chains rattling, and the air was pregnant with the alien smell of smoke.
                                
                "Who is there?" Obi asked yet again.
                                
                "Your neighbor," a silvery voice finally answered.
                                
                Obi glanced sideways before pulling the door handle, but there was no one there. He peeked into the hallway and shook his head, his breath escaping in a quick sigh.
                                
                He was about to shut the door when a sudden burst of smoke gripped him and hurled him to the floor, almost sucking air out from his body.
                                
                "Obimma, right?" A silhouetted figure with chains stood in the doorway.
                                
                Obi winced as he struggled to rise.
                                
                "How are you still conscious?" The silhouetted figure growled. "No one in this building has ever survived my blow."
                                
                Obi was kneeling, still trying to gain balance.
                                
                The figure lunged forward this second and staggered backward the next second as though there was an invisible shield in the doorway.
                                
                "Why can't I get in?" it yelled.
                                
                Obi was still on his knees but revivified.
                                
                With head raised, he said, "Because."
                                
                With one knee bent, he said, "I am."
                                
                And with legs up, he said, "New and different."
                                
                Then he grabbed the door and slammed it against the figure.
                                
                Thunder started to rage as if provoked again.
                                
                "I'll be back!" the figure roared.\s
                                
                "And I'll be ready!" Obi fired back.
                                
                *
                                
                Fiction?
                                
                Yes.
                                
                But let's quickly use this short piece to dish out some vital lessons.
                                
                *
                                
                Now, while some of us share a certain resemblance with Obi, some don't.
                                
                How so?
                                
                Let's take Obi's new apartment as a new level (a new phase) and the silhouetted figure as a new challenge.
                                
                Now, why do some of us pull up once we crush a certain goal―once we attain a certain level in life?
                                
                Why do we buy into the notion that once we've accomplished a given task, then that's it, no more tasks ahead?
                                
                Truth be told, Life is a journey filled with quests. Ergo, if you're going to pull up at some point to catch your breath, pull up.
                                
                But do keep in mind that it is not your final destination. Bear in mind that getting to a certain point doesn't equate to being free of challenges.
                                
                Whether or not you keep moving right away, you'll no doubt come face to face with challenges. Some will be small and others will loom large.
                                
                And you have to be ready. The best way to get through them is to be prepared for any situation that may be hurled your way.
                                
                I know if some of us had a choice, we would probably seek to avoid challenges.
                                
                However, despite one's best effort to avoid them, challenges arise and threaten one's journey. Thus, one must handle them.
                                
                It is best to be prepared for road bumps because you're bound to hit them from time to time as you go through life.
                                
                Don't arrive at a level in your life and get too comfortable with it. Besides, there is comfort in discomfort.
                                
                Yes.
                                
                And growth starts with a decision to move beyond your present circumstances.
                                
                "When things do not go your way, remember that every challenge — every adversity — contains within it the seeds of opportunity and growth." ― Roy T. Bennett.
                                
                A challenge only becomes an [absolute] obstacle when you bow to it.
                                
                Start that fire and keep it burning.
                                
                Have a high-yielding week!
                © Quincy Alagbu
                """);


        blogService.post(blogPostRequest,multipartFile);

    }

    @Test void testThatBlogListIsNotEmpty(){
        List<Blog> blogList = blogService.getAllPost();
        log.info("{}->",blogList);
    }

    @Test void testThatABlogCanBeEdited() throws IOException, BlogPostException {
        EditBlogRequest editBlogRequest = new EditBlogRequest();

        editBlogRequest.setId(1L);
        editBlogRequest.setDescription("testing");
        editBlogRequest.setPostNumber("2990");
        blogService.editBlog(editBlogRequest);
    }

    @Test void testThatABlogImageCanBeEdited() throws IOException, BlogPostException {
        File file = new File("/home/user/Pictures/house7.jpeg");
        FileInputStream inputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("filename",inputStream);

     blogService.editBlogImage(multipartFile,1L);
    }

    @Test void testDeleteCommentFromBlog() throws Exception {
        DeleteBlogCommentRequest request = new DeleteBlogCommentRequest();
        request.setBlogId(1L);
        request.setCommentId(1L);
        blogService.deleteBlogComment(request);
    }

}