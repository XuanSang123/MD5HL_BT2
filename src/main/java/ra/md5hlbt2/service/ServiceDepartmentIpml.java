package ra.md5hlbt2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.md5hlbt2.entity.Department;
import ra.md5hlbt2.repository.IRepositoryDepartment;

import java.util.List;
@Service
public class ServiceDepartmentIpml implements IServiceDepartment{
    @Autowired
    private IRepositoryDepartment iRepositoryDepartment;
    @Override
    public List<Department> findAll() {
        return iRepositoryDepartment.findAll();
    }

    @Override
    public Department findById(Integer id) {
        return iRepositoryDepartment.findById(id).orElse(null);
    }

    @Override
    public Department save(Department department) {
        return iRepositoryDepartment.save(department);
    }

    @Override
    public void delete(Integer id) {
iRepositoryDepartment.deleteById(id);
    }
}
