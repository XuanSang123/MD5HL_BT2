package ra.md5hlbt2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.md5hlbt2.entity.Customer;

public interface IRepositoryCustomer extends JpaRepository<Customer,Integer> {
}
