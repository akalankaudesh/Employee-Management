package lk.wixis360.rest.Services;

import lk.wixis360.rest.Dto.EmployeeDTO;
import lk.wixis360.rest.Dto.PaymentDTO;

import java.util.List;

public interface ManagePaymentService extends SuperService {
    List<PaymentDTO> getPayments();

    void createPayment(PaymentDTO paymentDTO);

    void deletePayment(String empID);

//    PaymentDTO findPayment(String empID);

}
