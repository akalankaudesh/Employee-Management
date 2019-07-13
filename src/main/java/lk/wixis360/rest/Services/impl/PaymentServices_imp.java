package lk.wixis360.rest.Services.impl;

import lk.wixis360.rest.Dto.EmployeeDTO;
import lk.wixis360.rest.Dto.PaymentDTO;
import lk.wixis360.rest.Entity.Employee;
import lk.wixis360.rest.Entity.EmployeeSalary;
import lk.wixis360.rest.Entity.Payment;
import lk.wixis360.rest.Repository.PaymentRepository;
import lk.wixis360.rest.Services.ManagePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentServices_imp implements ManagePaymentService {

    private PaymentRepository paymentDAO;

    @Autowired
    public PaymentServices_imp(PaymentRepository paymentRepositoryDAO) {
        this.paymentDAO = paymentRepositoryDAO;
    }


    @Override
    public List<PaymentDTO> getPayments() {
        List<PaymentDTO> payments=new ArrayList<>();

        for (Payment dto:paymentDAO.findAll()) {
            payments.add(new PaymentDTO(dto.getEmpsalary().getEmp_id(),dto.getEmpsalary().getMonth(),dto.getSalary()));
        }
        return payments;
    }

    @Override
    public void createPayment(PaymentDTO paymentDTO) {
        Payment emPayment = new Payment(new EmployeeSalary(paymentDTO.getEmp_id(),paymentDTO.getMonth()), paymentDTO.getSalary());
        paymentDAO.save(emPayment);
    }

    @Override
    public void deletePayment(String empID) {
        paymentDAO.deleteById(empID);
    }

//    @Override
//    public PaymentDTO findPayment(String empID) {
//        Optional<Payment> pay = paymentDAO.findById(empID);
//        PaymentDTO paymentDTO=null;
//        if(pay.isPresent()) {
//            Payment e = pay.get();
//            paymentDTO=new PaymentDTO(e.getEmp_id(),e.getMonth(),e.getSalary());
//        }
//
//        return paymentDTO;
//    }
}
