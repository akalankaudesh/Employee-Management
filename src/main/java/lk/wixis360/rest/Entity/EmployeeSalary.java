package lk.wixis360.rest.Entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class EmployeeSalary implements Serializable {

    @Column(name = "emp_id")
    private String emp_id;

    @Column(name = "month")
    private Date month;

    public EmployeeSalary() {
    }

    public EmployeeSalary(String emp_id, Date month) {
        this.emp_id = emp_id;
        this.month = month;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeSalary)) return false;
        EmployeeSalary that = (EmployeeSalary) o;
        return Objects.equals(getEmp_id(), that.getEmp_id()) &&
                Objects.equals(getMonth(), that.getMonth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmp_id(), getMonth());
    }

}
