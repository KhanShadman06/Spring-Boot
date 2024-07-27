package Demo_vlog.Controller;

import Demo_vlog.Model.PostLike;
import Demo_vlog.service.PostLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postlikes")
public class PostLikeController {

    @Autowired
    private PostLikeService postLikeService;

    @PostMapping
    public PostLike createPostLike(@RequestBody PostLike postLike) {
        return postLikeService.savePostLike(postLike);
    }

    @GetMapping
    public List<PostLike> getAllPostLikes() {
        return postLikeService.getAllPostLikes();
    }

    @GetMapping("/{id}")
    public PostLike getPostLikeById(@PathVariable Long id) {
        return postLikeService.getPostLikeById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePostLike(@PathVariable Long id) {
        postLikeService.deletePostLike(id);
    }
}
