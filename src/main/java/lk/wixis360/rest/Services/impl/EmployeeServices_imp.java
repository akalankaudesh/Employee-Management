package lk.wixis360.rest.Services.impl;

import lk.wixis360.rest.Dto.EmployeeDTO;
import lk.wixis360.rest.Entity.Employee;
import lk.wixis360.rest.Repository.EmployeeRepository;
import lk.wixis360.rest.Services.ManageEmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServices_imp implements ManageEmployeeServices {

    private EmployeeRepository employeeDAO;

    @Autowired
    public EmployeeServices_imp(EmployeeRepository employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Transactional(readOnly = true)
    public List<EmployeeDTO> getEmployees() {
        List<EmployeeDTO> Employee=new ArrayList<>();
        List<Employee> all = employeeDAO.findAll();
        for (Employee dto:all) {
             Employee.add(new EmployeeDTO(dto.getEmp_id(),dto.getEmp_name(),dto.getEmp_mobile(),dto.getEmp_address()));
        }
        return Employee;
    }

    @Override
    public void createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO.getEmp_id(), employeeDTO.getEmp_name(), employeeDTO.getEmp_mobile(), employeeDTO.getEmp_address());
        employeeDAO.save(employee);
    }

    @Override
    public void updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO.getEmp_id(), employeeDTO.getEmp_name(), employeeDTO.getEmp_mobile(), employeeDTO.getEmp_address());
        employeeDAO.save(employee);
    }

    @Override
    public void deleteEmployee(String empID) {
        employeeDAO.deleteById(empID);

    }

    @Override
    public EmployeeDTO findEmployee(String empID) {
        Optional<Employee> emp = employeeDAO.findById(empID);
        EmployeeDTO foundemployee=null;
        if(emp.isPresent()) {
            Employee e = emp.get();
            foundemployee=new EmployeeDTO(e.getEmp_id(),e.getEmp_name(),e.getEmp_mobile(),e.getEmp_address());
        }

        return foundemployee;
    }
}
