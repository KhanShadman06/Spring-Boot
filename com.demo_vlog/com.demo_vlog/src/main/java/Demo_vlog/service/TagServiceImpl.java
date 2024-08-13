package Demo_vlog.service;

import Demo_vlog.Model.Tag;
import Demo_vlog.Repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl {

    @Autowired
    private TagRepository tagRepository;

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public Tag getTagById(Long id) {
        return tagRepository.findById(id).orElse(null);
    }

    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag updateTag(Long id, Tag tag) {
        Tag existingTag = tagRepository.findById(id).orElse(null);
        if (existingTag != null) {
            existingTag.setName(tag.getName());
            // Add any other fields that need to be updated
            return tagRepository.save(existingTag);
        }
        return null;
    }

    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}
