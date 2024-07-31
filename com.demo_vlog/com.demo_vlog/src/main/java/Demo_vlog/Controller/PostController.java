package Demo_vlog.Controller;

import Demo_vlog.Model.post;
import Demo_vlog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping
    public post createPost(@RequestBody post post) {
        return postService.savePost(post);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/paginated")
    public Page<post> getPostsPaginated(@RequestParam int page, @RequestParam int size) {
        return postService.getPosts(PageRequest.of(page, size));
    }
}
