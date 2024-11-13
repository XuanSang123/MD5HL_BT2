package ra.md5hlbt2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.md5hlbt2.entity.Employee;
import ra.md5hlbt2.repository.IRepositoryEmployee;

import java.util.List;

@Service
public class ServiceEmployeeIpml implements IServiceEmployee {
    @Autowired
    private IRepositoryEmployee iRepositoryEmployee;

    @Override
    public List<Employee> findAll() {
        return iRepositoryEmployee.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return iRepositoryEmployee.findById(id).orElse(null);
    }

    @Override
    public Employee save(Employee employee) {
        return iRepositoryEmployee.save(employee);
    }

    @Override
    public void delete(Integer id) {
        iRepositoryEmployee.deleteById(id);
    }
}
