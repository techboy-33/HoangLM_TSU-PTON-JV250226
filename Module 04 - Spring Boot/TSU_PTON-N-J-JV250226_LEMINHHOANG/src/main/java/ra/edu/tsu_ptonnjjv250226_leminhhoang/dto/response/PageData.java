package ra.edu.tsu_ptonnjjv250226_leminhhoang.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageData <T>{
    private List<T> items;
    private Pagination pagination;
}
