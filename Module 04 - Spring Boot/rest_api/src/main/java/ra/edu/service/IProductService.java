package ra.edu.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import ra.edu.exception.NotFoundException;
import ra.edu.model.dto.DataResponse;
import ra.edu.model.entity.Product;

import java.util.List;

public interface IProductService {
    DataResponse<List<Product>> getAllProducts();
    DataResponse<Product> getProductById(Long id) throws NotFoundException;
}
