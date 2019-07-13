package lk.wixis360.rest.Repository;

import lk.wixis360.rest.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee,String>{
}
