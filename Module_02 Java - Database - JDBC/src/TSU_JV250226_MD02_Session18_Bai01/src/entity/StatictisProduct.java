package entity;

public class StatictisProduct {
    private String catalog;
    private int cntProduct;

    public StatictisProduct() {}

    public StatictisProduct(String catalog, int cntProduct) {}

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public int getCntProduct() {
        return cntProduct;
    }

    public void setCntProduct(int cntProduct) {
        this.cntProduct = cntProduct;
    }

    @Override
    public String toString() {
        return String.format("Danh mục %s có %d sản phẩm \n", catalog, cntProduct);
    }
}
