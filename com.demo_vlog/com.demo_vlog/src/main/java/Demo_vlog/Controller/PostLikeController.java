package Demo_vlog.Controller;

import Demo_vlog.Model.PostLike;
import Demo_vlog.service.PostLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post likes")
public class PostLikeController {

    @Autowired
    private PostLikeService postLikeService;
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping
    public PostLike createPostLike(@RequestBody PostLike postLike) {
        return postLikeService.savePostLike(postLike);
    }
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping
    public List<PostLike> getAllPostLikes() {
        return postLikeService.getAllPostLikes();
    }
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/{id}")
    public PostLike getPostLikeById(@PathVariable Long id) {
        return postLikeService.getPostLikeById(id);
    }
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deletePostLike(@PathVariable Long id) {
        postLikeService.deletePostLike(id);
    }
}
