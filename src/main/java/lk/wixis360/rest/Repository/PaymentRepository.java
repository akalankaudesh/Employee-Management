package lk.wixis360.rest.Repository;

import lk.wixis360.rest.Dto.PaymentDTO;
import lk.wixis360.rest.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,String> {
}
