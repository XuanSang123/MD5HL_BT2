package ra.md5hlbt2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ra.md5hlbt2.entity.Blog;

public interface IRepositoryBlog extends JpaRepository<Blog,Integer> {
    Page<Blog> findAllBlog(Pageable pageable);
}
