package lk.wixis360.rest.Services;

import lk.wixis360.rest.Dto.EmployeeDTO;

import java.util.List;

public interface ManageEmployeeServices extends SuperService {

    List<EmployeeDTO> getEmployees();

    void createEmployee(EmployeeDTO employeeDTO);

    void updateEmployee(EmployeeDTO employeeDTO);

    void deleteEmployee(String empID);

    EmployeeDTO findEmployee(String empID);

}
