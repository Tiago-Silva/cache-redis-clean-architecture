package br.com.cacheredis.application.usecases;

import br.com.cacheredis.application.gateways.ProductGateway;
import br.com.cacheredis.domain.entity.Product;

import java.util.List;

public class ProductInteractor {

    private final ProductGateway productGateway;
    public ProductInteractor(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public Product createProduct(Product product) {
        return this.productGateway.createProduct(product);
    }
    public Product updateProduct(Product product) {
        return this.productGateway.updateProduct(product);
    }
    public void deleteProduct(Product product) {
        this.productGateway.deleteProduct(product);
    }
    public List<Product> getAllProducts() {
        return this.productGateway.getAllProducts();
    }
    public Product getProductById(int idproduto) {
        return this.productGateway.getProductById(idproduto);
    }
    public List<Product> getProductByCategory(String category) {
        return this.productGateway.getProductByCategory(category);
    }
    public List<Product> getProductByIsPromotion(Boolean isPromotion) {
        return this.productGateway.getProductByIsPromotion(isPromotion);
    }
}
