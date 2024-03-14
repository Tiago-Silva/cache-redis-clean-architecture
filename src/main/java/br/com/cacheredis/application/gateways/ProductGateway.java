package br.com.cacheredis.application.gateways;

import br.com.cacheredis.domain.entity.Product;

import java.util.List;

public interface ProductGateway {

    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(int idproduto);
    List<Product> getProductByCategory(String category);
    List<Product> getProductByIsPromotion(Boolean isPromotion);
}
