package ra.md5hlbt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.md5hlbt2.entity.Customer;
import ra.md5hlbt2.service.IServiceCustomer;
import ra.md5hlbt2.service.IServiceProject;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private IServiceCustomer iServiceCustomer;
    @Autowired
    private IServiceProject iServiceProject;

    @GetMapping
    public String getAllCustomers(Model model) {
        model.addAttribute("Customers", iServiceCustomer.findAll());
        return "customer/listCustomer";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        iServiceCustomer.delete(id);
        return "redirect:/customer";
    }

    @GetMapping("/add")
    public String addCustomer(Model model) {
        model.addAttribute("projects", iServiceProject.findAll());
        model.addAttribute("customer", new Customer());
        return "customer/addCustomer";
    }


    @PostMapping("/add")
    public String saveCustomer(@ModelAttribute Customer customer) {
        iServiceCustomer.save(customer);
        return "redirect:/customer";
    }


    @GetMapping("/edit/{id}")
    public String editCustomer(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", iServiceCustomer.findById(id));
        return "customer/editCustomer";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute Customer customer) {
        iServiceCustomer.save(customer);
        return "redirect:/customer";
    }

}
