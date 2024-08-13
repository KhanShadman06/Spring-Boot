package Demo_vlog.service;

import Demo_vlog.Model.Author;
import Demo_vlog.Model.BlogPost;
import java.util.List;

public interface AuthorService {
    Author saveAuthor(Author author);
    List<Author> getAllAuthors();
    Author getAuthorById(Long id);
    void deleteAuthor(Long id);
    List<BlogPost> getBlogPostsByAuthor(Author author);
    List<BlogPost> getBlogPostsByAuthorId(Long authorId); // New method
}
