package Demo_vlog.Controller;

import Demo_vlog.Model.PostLike;
import Demo_vlog.service.PostLikeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post-likes")
public class PostLikeController {

    @Autowired
    private PostLikeServiceImpl postLikeService;

    @GetMapping
    public ResponseEntity<List<PostLike>> getAllPostLikes() {
        List<PostLike> postLikes = postLikeService.getAllPostLikes();
        return ResponseEntity.ok(postLikes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostLike> getPostLikeById(@PathVariable Long id) {
        PostLike postLike = postLikeService.getPostLikeById(id);
        return ResponseEntity.ok(postLike);
    }

    @PostMapping
    public ResponseEntity<PostLike> createPostLike(@RequestBody PostLike postLike) {
        PostLike createdPostLike = postLikeService.createPostLike(postLike);
        return ResponseEntity.ok(createdPostLike);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostLike> updatePostLike(@PathVariable Long id, @RequestBody PostLike postLike) {
        PostLike updatedPostLike = postLikeService.updatePostLike(id, postLike);
        return ResponseEntity.ok(updatedPostLike);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostLike(@PathVariable Long id) {
        postLikeService.deletePostLike(id);
        return ResponseEntity.noContent().build();
    }
}
