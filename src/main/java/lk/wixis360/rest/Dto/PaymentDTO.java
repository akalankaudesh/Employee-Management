package lk.wixis360.rest.Dto;

import java.util.Date;

public class PaymentDTO {

   private String emp_id;
   private Date month;
   private Double salary;

    public PaymentDTO() {
    }

    public PaymentDTO(String emp_id, Date month, Double salary) {
        this.emp_id = emp_id;
        this.month = month;
        this.salary = salary;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "emp_id='" + emp_id + '\'' +
                ", month=" + month +
                ", salary=" + salary +
                '}';
    }


}
