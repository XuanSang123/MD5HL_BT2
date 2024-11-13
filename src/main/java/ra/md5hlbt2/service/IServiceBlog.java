package ra.md5hlbt2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.md5hlbt2.IService;
import ra.md5hlbt2.entity.Blog;

public interface IServiceBlog extends IService<Blog,Integer> {
    Page<Blog> findAll(Pageable pageable);
}
