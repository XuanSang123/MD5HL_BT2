package ra.md5hlbt2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.md5hlbt2.entity.Customer;
import ra.md5hlbt2.repository.IRepositoryCustomer;

import java.util.List;
@Service
public class ServiceCustomerIpml implements IServiceCustomer {
    @Autowired
    private IRepositoryCustomer iRepositoryCustomer;

    @Override
    public List<Customer> findAll() {
        return iRepositoryCustomer.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return iRepositoryCustomer.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return iRepositoryCustomer.save(customer);
    }

    @Override
    public void delete(Integer id) {
        iRepositoryCustomer.deleteById(id);
    }
}
