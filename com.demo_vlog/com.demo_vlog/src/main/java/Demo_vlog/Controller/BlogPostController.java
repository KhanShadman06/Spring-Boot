package Demo_vlog.Controller;

import Demo_vlog.Model.BlogPost;
import Demo_vlog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blogposts")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("/paginated")
    public Page<BlogPost> getPaginatedPosts(@RequestParam int page, @RequestParam int size) {
        return blogPostService.getPaginatedBlogPosts(PageRequest.of(page, size));
    }
}
