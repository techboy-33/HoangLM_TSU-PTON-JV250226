package ra.edu.tsu_ptonnjjv250226_leminhhoang.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.edu.tsu_ptonnjjv250226_leminhhoang.config.exception.ConflictDataException;
import ra.edu.tsu_ptonnjjv250226_leminhhoang.config.exception.NotFoundException;
import ra.edu.tsu_ptonnjjv250226_leminhhoang.dto.request.InventoryAddDto;
import ra.edu.tsu_ptonnjjv250226_leminhhoang.dto.request.UpdateInventoryDto;
import ra.edu.tsu_ptonnjjv250226_leminhhoang.dto.response.APIResponse;
import ra.edu.tsu_ptonnjjv250226_leminhhoang.dto.response.PageData;
import ra.edu.tsu_ptonnjjv250226_leminhhoang.entity.InventoryManagement;
import ra.edu.tsu_ptonnjjv250226_leminhhoang.service.InventoryManagementService;

@RestController
@RequestMapping("/api/inventoryManagement")
public class InventoryManagementController {
    @Autowired
    private InventoryManagementService inventoryManagementService;

    @GetMapping
    public ResponseEntity<APIResponse<PageData<InventoryManagement>, Object>> getAllInventoryManagement(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "20") int size
    ){
        return new ResponseEntity<>(inventoryManagementService.getAllInventoris(page, size), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<APIResponse<PageData<InventoryManagement>, Object>> searchInventoryManagement(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String producer,
            @RequestParam(required = false) Integer minQuantity,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "20") int size
    ) {
        if (name != null) {
            return ResponseEntity.ok(inventoryManagementService.searchByName(name, page, size));
        } else if (producer != null && minQuantity != null) {
            return ResponseEntity.ok(inventoryManagementService.searchByProducerAndQuantity(producer, minQuantity, page, size));
        } else {
            return ResponseEntity.ok(inventoryManagementService.getAllInventoris(page, size));
        }
    }

    @PostMapping
    public ResponseEntity<APIResponse<InventoryManagement, Object>> addInventoryManagement(@Valid @RequestBody InventoryAddDto request) throws ConflictDataException {
        return new ResponseEntity<>(inventoryManagementService.addInventory(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<InventoryManagement, Object>> updateInventoryManagement(@Valid @RequestBody UpdateInventoryDto request, @PathVariable Integer id) throws ConflictDataException, NotFoundException {
        return new  ResponseEntity<>(inventoryManagementService.updateInventory(request, id), HttpStatus.OK);
    }
}
