package ra.edu.session_04.service;

import ra.edu.session_04.model.entity.OrderDetail;
import ra.edu.session_04.repository.OrderDetailRepository;
import ra.edu.session_04.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public void save(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
    }
}
