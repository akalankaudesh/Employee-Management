package lk.wixis360.rest.Entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "salary")
public class Payment {

    @EmbeddedId
    private EmployeeSalary empsalary;
    private Double salary;

    public Payment() {
    }

    public Payment(EmployeeSalary empsalary, Double salary) {
        this.empsalary = empsalary;
        this.salary = salary;
    }

    public EmployeeSalary getEmpsalary() {
        return empsalary;
    }

    public void setEmpsalary(EmployeeSalary empsalary) {
        this.empsalary = empsalary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "empsalary=" + empsalary +
                ", salary=" + salary +
                '}';
    }
}
