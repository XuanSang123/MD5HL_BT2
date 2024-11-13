package ra.md5hlbt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.md5hlbt2.entity.Department;
import ra.md5hlbt2.service.IServiceDepartment;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private IServiceDepartment iServiceDepartment;


    @GetMapping
    public String showDepartment(Model model) {
        model.addAttribute("departments", iServiceDepartment.findAll());
        return "department/listDepartment";
    }

    @RequestMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable Integer id) {
        iServiceDepartment.delete(id);
        return "redirect:/department";
    }

    @GetMapping("/add")
    public String formAdd() {
        return "department/addDepartment";
    }

    @PostMapping("/add")
    public String doAdd(Model model, @ModelAttribute Department department) {
        iServiceDepartment.save(department);
        return "redirect:/department";
    }

    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("department", iServiceDepartment.findById(id));
        return "department/editDepartment";

    }
    @PostMapping("/update")
    public String doUpdate(Model model, @ModelAttribute Department department) {
        iServiceDepartment.save(department);
        return "redirect:/department";
    }

}
