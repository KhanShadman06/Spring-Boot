package Demo_vlog.Controller;

import Demo_vlog.Model.Tag;
import Demo_vlog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping
    public Tag createTag(@RequestBody Tag tag) {
        return tagService.saveTag(tag);
    }

    @GetMapping
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @GetMapping("/{id}")
    public Tag getTagById(@PathVariable Long id) {
        return tagService.getTagById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
    }
}
