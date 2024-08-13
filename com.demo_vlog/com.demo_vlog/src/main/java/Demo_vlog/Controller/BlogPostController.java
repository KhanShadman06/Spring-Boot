package Demo_vlog.Controller;

import Demo_vlog.Model.BlogPost;
import Demo_vlog.service.BlogPostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class BlogPostController {

    @Autowired
    private BlogPostServiceImpl blogPostService;

    // Endpoint to get paginated blog posts
    @GetMapping("/paginated")
    public ResponseEntity<Page<BlogPost>> getAllPostsPaginated(@PageableDefault(size = 10) Pageable pageable) {
        Page<BlogPost> posts = blogPostService.getAllPosts(pageable);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> getPostById(@PathVariable Long id) {
        BlogPost post = blogPostService.getPostById(id);
        return ResponseEntity.ok(post);
    }

    @PostMapping
    public ResponseEntity<BlogPost> createPost(@RequestBody BlogPost post) {
        BlogPost createdPost = blogPostService.createPost(post);
        return ResponseEntity.ok(createdPost);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updatePost(@PathVariable Long id, @RequestBody BlogPost post) {
        BlogPost updatedPost = blogPostService.updatePost(id, post);
        return ResponseEntity.ok(updatedPost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        blogPostService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
