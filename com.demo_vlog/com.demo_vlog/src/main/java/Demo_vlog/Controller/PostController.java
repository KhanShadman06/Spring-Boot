package Demo_vlog.Controller;

import Demo_vlog.Model.post;
import Demo_vlog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public post createPost(@RequestBody post post) {
        return postService.savePost(post);
    }

    @GetMapping
    public List<post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
