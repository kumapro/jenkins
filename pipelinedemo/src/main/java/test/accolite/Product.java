package test.accolite;

import java.util.Objects;

public class Product {
    private long prodId;
    private String prodName;
    private ProductType productType;

    public Product(){

    }

    public Product(long prodId, String prodName, ProductType productType) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.productType = productType;
    }

    public long getProdId() {
        return prodId;
    }

    public void setProdId(long prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return prodId == product.prodId &&
                Objects.equals(prodName, product.prodName) &&
                Objects.equals(productType, product.productType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodId, prodName, productType);
    }
}
