package ra.edu.tsu_ptonnjjv250226_leminhhoang.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InventoryAddDto {

    @NotBlank(message = "Tên vật tư không được để trống")
    @Size(max = 100, message = "Tên vật tư tối đa 100 ký tự")
    private String materialName;

    @NotBlank(message = "Nhà cung cấp không được để trống")
    @Size(max = 100, message = "Nhà cung cấp tối đa 100 ký tự")
    private String producer;

    @NotNull(message = "Số lượng không được để trống")
    @Positive(message = "Số lượng phải lớn hơn 0")
    private Integer quantity;

    @NotNull(message = "Giá không được để trống")
    @Positive(message = "Giá phải lớn hơn 0")
    private Double price;

    @NotBlank(message = "Đơn vị giá không được để trống")
    @Size(max = 10, message = "Đơn vị giá tối đa 10 ký tự")
    private String priceUnit;

    @Size(max = 255, message = "URL ảnh tối đa 255 ký tự")
    private String imageUrl;

    @Size(max = 255, message = "Ghi chú tối đa 255 ký tự")
    private String note;

    private Boolean status = true;
}
