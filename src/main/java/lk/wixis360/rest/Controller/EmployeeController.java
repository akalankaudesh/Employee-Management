package lk.wixis360.rest.Controller;

import lk.wixis360.rest.Dto.EmployeeDTO;
import lk.wixis360.rest.Services.ManageEmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value="/api/rest/employees")
@CrossOrigin
@RestController
public class EmployeeController {

    @Autowired
    private ManageEmployeeServices employeeServices;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> findEmployee(@PathVariable("id") String empid) {
        EmployeeDTO employee = employeeServices.findEmployee(empid);
        HttpStatus status = (employee !=null)? HttpStatus.OK: HttpStatus.NOT_FOUND;
        return new ResponseEntity<EmployeeDTO>(employee, status);
    }


    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAllEmployees() {
        List<EmployeeDTO> employees = employeeServices.getEmployees();
        return new ResponseEntity<List<EmployeeDTO>>(employees, HttpStatus.OK);
    }



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveEmployee(@RequestBody EmployeeDTO employee) {
        employeeServices.createEmployee(employee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable("id") String empid) {
        employeeServices.deleteEmployee(empid);
    }

    @PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateEmployee(@PathVariable("id") String empid,
                                         @RequestBody EmployeeDTO employee) {
        if (empid.equals(employee.getEmp_id())) {
            employeeServices.updateEmployee(employee);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
