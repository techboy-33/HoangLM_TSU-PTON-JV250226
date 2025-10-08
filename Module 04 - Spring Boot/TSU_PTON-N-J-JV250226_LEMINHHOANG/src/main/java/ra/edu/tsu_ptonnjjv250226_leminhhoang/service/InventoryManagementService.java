package ra.edu.tsu_ptonnjjv250226_leminhhoang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ra.edu.tsu_ptonnjjv250226_leminhhoang.config.exception.ConflictDataException;
import ra.edu.tsu_ptonnjjv250226_leminhhoang.config.exception.NotFoundException;
import ra.edu.tsu_ptonnjjv250226_leminhhoang.dto.request.InventoryAddDto;
import ra.edu.tsu_ptonnjjv250226_leminhhoang.dto.request.UpdateInventoryDto;
import ra.edu.tsu_ptonnjjv250226_leminhhoang.dto.response.APIResponse;
import ra.edu.tsu_ptonnjjv250226_leminhhoang.dto.response.PageData;
import ra.edu.tsu_ptonnjjv250226_leminhhoang.dto.response.Pagination;
import ra.edu.tsu_ptonnjjv250226_leminhhoang.entity.InventoryManagement;
import ra.edu.tsu_ptonnjjv250226_leminhhoang.mapper.InventoryMapper;
import ra.edu.tsu_ptonnjjv250226_leminhhoang.repository.InventoryManagementRepository;


@Service
public class InventoryManagementService {
    @Autowired
    private InventoryManagementRepository inventoryManagementRepository;
    @Autowired
    private InventoryMapper inventoryMapper;

    public APIResponse<PageData<InventoryManagement>, Object> getAllInventoris(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<InventoryManagement> pageJpa = inventoryManagementRepository.findAll(pageable);

        Pagination pagination = new Pagination();
        pagination.setCurrentPage(page);
        pagination.setPageSize(size);
        pagination.setTotalPages(pageJpa.getTotalPages());
        pagination.setTotalItems(pageJpa.getTotalElements());

        PageData<InventoryManagement> pageData = new PageData<>();
        pageData.setItems(pageJpa.getContent());
        pageData.setPagination(pagination);

        APIResponse<PageData<InventoryManagement>, Object> response = new APIResponse<>();
        response.setSuccess(true);
        response.setMessage("Lấy dữ liệu thành công");
        response.setData(pageData);
        response.setHttpStatus(HttpStatus.OK.value());
        return response;
    }

    public APIResponse<PageData<InventoryManagement>, Object> searchByName(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<InventoryManagement> pageJpa = inventoryManagementRepository.findAllByMaterialNameContaining(name, pageable);

        Pagination pagination = new Pagination();
        pagination.setCurrentPage(page);
        pagination.setPageSize(size);
        pagination.setTotalPages(pageJpa.getTotalPages());
        pagination.setTotalItems(pageJpa.getTotalElements());

        PageData<InventoryManagement> pageData = new PageData<>();
        pageData.setItems(pageJpa.getContent());
        pageData.setPagination(pagination);

        APIResponse<PageData<InventoryManagement>, Object> response = new APIResponse<>();
        response.setSuccess(true);
        response.setMessage("Tìm kiếm theo tên thành công");
        response.setData(pageData);
        response.setHttpStatus(HttpStatus.OK.value());
        return response;
    }
    public APIResponse<PageData<InventoryManagement>, Object> searchByProducerAndQuantity(String name, Integer minQuantity, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<InventoryManagement> pageJpa = inventoryManagementRepository.findAllByProducerContainingAndQuantityGreaterThanEqual(name, minQuantity, pageable);

        Pagination pagination = new Pagination();
        pagination.setCurrentPage(page);
        pagination.setPageSize(size);
        pagination.setTotalPages(pageJpa.getTotalPages());
        pagination.setTotalItems(pageJpa.getTotalElements());

        PageData<InventoryManagement> pageData = new PageData<>();
        pageData.setItems(pageJpa.getContent());
        pageData.setPagination(pagination);

        APIResponse<PageData<InventoryManagement>, Object> response = new APIResponse<>();
        response.setSuccess(true);
        response.setMessage("Tìm kiếm theo tên và số lượng thành công");
        response.setData(pageData);
        response.setHttpStatus(HttpStatus.OK.value());
        return response;
    }

    public APIResponse<InventoryManagement, Object> getInventoryById(Integer id) throws NotFoundException {
        APIResponse<InventoryManagement, Object> response = new APIResponse<>();
        response.setSuccess(true);
        response.setMessage("Lấy dữ liệu thành công");
        response.setData(inventoryManagementRepository.findById(id).orElseThrow(() -> new NotFoundException("Sản phẩm với id: " +id+ "không tồn tại")));
        response.setHttpStatus(HttpStatus.OK.value());
        return response;
    }

    public APIResponse<InventoryManagement, Object> addInventory (InventoryAddDto request) throws ConflictDataException {
        if (inventoryManagementRepository.existsByMaterialName(request.getMaterialName())) {
            throw new ConflictDataException("Trùng tên");
        }
        InventoryManagement entity = inventoryManagementRepository.save(inventoryMapper.mapToEntity(request));

        APIResponse<InventoryManagement, Object> response = new APIResponse<>();
        response.setSuccess(true);
        response.setMessage("Thêm dữ liệu thành công");
        response.setData(entity);
        response.setHttpStatus(HttpStatus.OK.value());
        return response;
    }

    public APIResponse<InventoryManagement, Object> updateInventory (UpdateInventoryDto request, Integer id) throws ConflictDataException, NotFoundException {
        if (inventoryManagementRepository.existsByMaterialNameForUpdate(request.getMaterialName(), id)) {
            throw  new ConflictDataException("Trùng tên");
        }

        InventoryManagement old = inventoryManagementRepository.findById(id).orElseThrow(() -> new NotFoundException("Sản phẩm với " +id+ "không tồn tại"));

        InventoryManagement newInventory = inventoryMapper.mapToEntity(request, old);
        newInventory.setInventoryId(id);
        InventoryManagement entity = inventoryManagementRepository.save(newInventory);

        APIResponse<InventoryManagement, Object> response = new APIResponse<>();
        response.setSuccess(true);
        response.setMessage("Cập nhật thành công");
        response.setData(entity);
        response.setHttpStatus(HttpStatus.OK.value());
        return  response;
    }
}
