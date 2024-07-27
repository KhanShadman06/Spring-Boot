package Demo_vlog.service;

import Demo_vlog.Model.Tag;

import java.util.List;

public interface TagService {
    Tag saveTag(Tag tag);
    List<Tag> getAllTags();
    Tag getTagById(Long id);
    void deleteTag(Long id);
}
