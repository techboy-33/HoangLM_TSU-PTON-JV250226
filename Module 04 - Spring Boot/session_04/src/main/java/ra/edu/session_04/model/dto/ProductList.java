package ra.edu.session_04.model.dto;

import ra.edu.session_04.model.entity.ProductExercise01;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JacksonXmlRootElement(localName = "products")
public class ProductList {
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<ProductExercise01> product;
}