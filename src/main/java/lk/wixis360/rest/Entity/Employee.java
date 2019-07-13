package lk.wixis360.rest.Entity;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    private String emp_id;
    private String emp_name;
    private String emp_mobile;
    private String emp_address;


    public Employee() {
    }

    public Employee(String emp_id, String emp_name, String emp_mobile, String emp_address) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_mobile = emp_mobile;
        this.emp_address = emp_address;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_mobile() {
        return emp_mobile;
    }

    public void setEmp_mobile(String emp_mobile) {
        this.emp_mobile = emp_mobile;
    }

    public String getEmp_address() {
        return emp_address;
    }

    public void setEmp_address(String emp_address) {
        this.emp_address = emp_address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id='" + emp_id + '\'' +
                ", emp_name='" + emp_name + '\'' +
                ", emp_mobile='" + emp_mobile + '\'' +
                ", emp_address='" + emp_address + '\'' +
                '}';
    }
}
