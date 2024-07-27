package Demo_vlog.Controller;

import Demo_vlog.Model.BlogPost;
import Demo_vlog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogposts")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @PostMapping
    public BlogPost createBlogPost(@RequestBody BlogPost blogPost) {
        return blogPostService.saveBlogPost(blogPost);
    }

    @GetMapping
    public List<BlogPost> getAllBlogPosts() {
        return blogPostService.getAllBlogPosts();
    }

    @GetMapping("/{id}")
    public BlogPost getBlogPostById(@PathVariable Long id) {
        return blogPostService.getBlogPostById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBlogPost(@PathVariable Long id) {
        blogPostService.deleteBlogPost(id);
    }
}
