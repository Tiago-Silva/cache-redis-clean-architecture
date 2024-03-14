package br.com.cacheredis.infrastructure.gateways;

import br.com.cacheredis.domain.entity.Product;
import br.com.cacheredis.infrastructure.db.entitydb.ProductDB;

public class ProductMapper {

    ProductDB toProductDB(Product product) {
        return new ProductDB(product);
    }

    Product toProduct(ProductDB productDB) {
        return new Product(productDB);
    }
}
