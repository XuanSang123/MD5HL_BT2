package ra.md5hlbt2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ra.md5hlbt2.entity.Blog;
import ra.md5hlbt2.repository.IRepositoryBlog;

import java.util.List;

@Service
public class ServiceBlogIpml implements IServiceBlog {

    @Autowired
    private IRepositoryBlog iRepositoryBlog;

    @Override
    public List<Blog> findAll() {
        return iRepositoryBlog.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iRepositoryBlog.findAllBlog(pageable);
    }

    @Override
    public Blog findById(Integer id) {
        return iRepositoryBlog.findById(id).orElse(null);
    }

    @Override
    public Blog save(Blog blog) {
        return iRepositoryBlog.save(blog);
    }

    @Override
    public void delete(Integer id) {
        iRepositoryBlog.deleteById(id);
    }
}
