package ra.edu.tsu_ptonnjjv250226_leminhhoang.mapper;

import org.springframework.stereotype.Component;
import ra.edu.tsu_ptonnjjv250226_leminhhoang.dto.request.InventoryAddDto;
import ra.edu.tsu_ptonnjjv250226_leminhhoang.dto.request.UpdateInventoryDto;
import ra.edu.tsu_ptonnjjv250226_leminhhoang.entity.InventoryManagement;

@Component
public class InventoryMapper {
    public InventoryManagement mapToEntity(InventoryAddDto request) {
        InventoryManagement inventoryManagement = new InventoryManagement();
        inventoryManagement.setMaterialName(request.getMaterialName());
        inventoryManagement.setProducer(request.getProducer());
        inventoryManagement.setQuantity(request.getQuantity());
        inventoryManagement.setPrice(request.getPrice());
        inventoryManagement.setPriceUnit(request.getPriceUnit());
        inventoryManagement.setNote(request.getNote());
        inventoryManagement.setImageUrl(request.getImageUrl());
        inventoryManagement.setStatus(request.getStatus());
        return inventoryManagement;
    }

    public InventoryManagement mapToEntity(UpdateInventoryDto request, InventoryManagement old) {
        old.setMaterialName(request.getMaterialName());
        old.setProducer(request.getProducer());
        old.setQuantity(request.getQuantity());
        old.setPrice(request.getPrice());
        old.setPriceUnit(request.getPriceUnit());
        old.setNote(request.getNote());
        old.setImageUrl(request.getImageUrl());
        old.setStatus(request.getStatus());
        return old;
    }
}
