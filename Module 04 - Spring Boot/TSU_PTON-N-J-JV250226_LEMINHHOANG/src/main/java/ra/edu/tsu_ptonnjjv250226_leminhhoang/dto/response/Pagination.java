package ra.edu.tsu_ptonnjjv250226_leminhhoang.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pagination {
    private int currentPage;
    private int pageSize;
    private int totalPages;
    private long totalItems;
}
