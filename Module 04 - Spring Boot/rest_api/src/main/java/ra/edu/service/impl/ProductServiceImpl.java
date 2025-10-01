package ra.edu.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ra.edu.exception.NotFoundException;
import ra.edu.model.dto.DataResponse;
import ra.edu.model.entity.Product;
import ra.edu.repository.IProductRepository;
import ra.edu.service.IProductService;

import java.time.LocalDateTime;
import java.util.List;

@Service@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final IProductRepository productRepository;

    @Override
    public DataResponse<List<Product>> getAllProducts() {
        return DataResponse.<List<Product>>builder()
                .success(true)
                .message("Get all products successfully!")
                .data(productRepository.findAll())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @Override
    public DataResponse<Product> getProductById(Long id) throws NotFoundException {
        return DataResponse.<Product>builder()
                .success(true)
                .data(productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found with id: " + id)))
                .timestamp(LocalDateTime.now())
                .build();
    }
}
