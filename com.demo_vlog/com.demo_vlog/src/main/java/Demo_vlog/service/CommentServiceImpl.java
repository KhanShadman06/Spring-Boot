package Demo_vlog.service;

import Demo_vlog.Model.Comment;
import Demo_vlog.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateComment(Long id, Comment comment) {
        Comment existingComment = commentRepository.findById(id).orElse(null);
        if (existingComment != null) {
            existingComment.setId(comment.getId());
            existingComment.setBlogPost(comment.getBlogPost());
            // Add any other fields that need to be updated
            return commentRepository.save(existingComment);
        }
        return null;
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
