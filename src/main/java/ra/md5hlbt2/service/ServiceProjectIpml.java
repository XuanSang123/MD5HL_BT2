package ra.md5hlbt2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.md5hlbt2.entity.Project;
import ra.md5hlbt2.repository.IRepositoryProject;

import java.util.List;

@Service
public class ServiceProjectIpml implements IServiceProject {
    @Autowired
    private IRepositoryProject iRepositoryProject;

    @Override
    public List<Project> findAll() {
        return iRepositoryProject.findAll();
    }

    @Override
    public Project findById(Integer id) {
        return iRepositoryProject.findById(id).orElse(null);
    }

    @Override
    public Project save(Project project) {
        return iRepositoryProject.save(project);
    }

    @Override
    public void delete(Integer id) {
        iRepositoryProject.deleteById(id);
    }
}
