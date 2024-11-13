package ra.md5hlbt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.md5hlbt2.entity.Project;
import ra.md5hlbt2.service.IServiceProject;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private IServiceProject iServiceProject;

    @RequestMapping
    public String showProject(Model model) {
        model.addAttribute("projects", iServiceProject.findAll());
        return "project/listProduct";
    }

    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable Integer id) {
        iServiceProject.delete(id);
        return "redirect:/project";
    }

    @GetMapping("/add")
    public String addProject() {
        return "project/addProduct";
    }

    @PostMapping("/add")
    public String addProject(@ModelAttribute Project project) {
        iServiceProject.save(project);
        return "redirect:/project";
    }


    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("project", iServiceProject.findById(id));
        return "project/editProject";
    }

    @PostMapping("/update")
    public String doUpdate(Model model, @ModelAttribute Project project) {
        iServiceProject.save(project);
        return "redirect:/project";
    }

}
