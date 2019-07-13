package lk.wixis360.rest.Controller;

import lk.wixis360.rest.Dto.EmployeeDTO;
import lk.wixis360.rest.Dto.PaymentDTO;
import lk.wixis360.rest.Services.ManagePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value="/api/rest/payments")
@CrossOrigin
@RestController
public class PaymentController {

    @Autowired
    private ManagePaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<PaymentDTO>> findAllPayments() {
        List<PaymentDTO> payments = paymentService.getPayments();
        return new ResponseEntity<List<PaymentDTO>>(payments, HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<PaymentDTO> findPayment(@PathVariable("id") String empid) {
//        PaymentDTO payment = paymentService.findPayment(empid);
//        HttpStatus status = (payment !=null)? HttpStatus.OK: HttpStatus.NOT_FOUND;
//        return new ResponseEntity<PaymentDTO>(payment, status);
 //   }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void savePayment(@RequestBody PaymentDTO paymentDTO) {
        paymentService.createPayment(paymentDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePayment(@PathVariable("id") String empid) {
        paymentService.deletePayment(empid);
    }

}
