package ra.md5hlbt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.md5hlbt2.entity.Blog;
import ra.md5hlbt2.service.IServiceBlog;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IServiceBlog iServiceBlog;

    @GetMapping
    public String showBlogs(@RequestParam(value = "page", defaultValue = "0") int page, Model model) {
        // Tạo đối tượng Pageable với số trang và kích thước mỗi trang
        Page<Blog> blogs = iServiceBlog.findAll(PageRequest.of(page, 5)); // Hiển thị 5 blog mỗi trang
        model.addAttribute("blogs", blogs); // Truyền dữ liệu phân trang vào model
        return "blog/listBlog";
    }


    @GetMapping("/add")
    public String formAdd() {
        return "blog/addBlog";
    }


    @PostMapping("/add")
    public String doAdd(Model model, @ModelAttribute Blog blog) {
        iServiceBlog.save(blog);
        return "redirect:/blog";
    }


    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Integer id) {
        iServiceBlog.delete(id);
        return "redirect:/blog";
    }


    @GetMapping("/edit/{id}")
    public String editBlog(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", iServiceBlog.findById(id));
        return "blog/editBlog";
    }


    @PostMapping("/edit")
    public String doEdit(Model model, @ModelAttribute Blog blog) {
        iServiceBlog.save(blog);
        return "redirect:/blog";
    }
}
