package Demo_vlog.service;

import Demo_vlog.Model.PostLike;

import java.util.List;

public interface PostLikeService {
    PostLike savePostLike(PostLike postLike);
    List<PostLike> getAllPostLikes();
    PostLike getPostLikeById(Long id);
    void deletePostLike(Long id);
}
