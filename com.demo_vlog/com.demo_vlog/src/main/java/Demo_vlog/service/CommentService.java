package Demo_vlog.service;

import Demo_vlog.Model.Comment;

import java.util.List;

public interface CommentService {
    Comment saveComment(Comment comment);
    List<Comment> getAllComments();
    Comment getCommentById(Long id);
    void deleteComment(Long id);
}
