package br.com.cacheredis.infrastructure.gateways;

import br.com.cacheredis.application.gateways.ProductGateway;
import br.com.cacheredis.domain.entity.Product;
import br.com.cacheredis.infrastructure.db.entitydb.ProductDB;
import br.com.cacheredis.infrastructure.repositories.ProductRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

public class ProductRepositoryGateway implements ProductGateway {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final HashOperations<String, Integer, Product> hashOperations;
    public ProductRepositoryGateway(ProductRepository productRepository, ProductMapper productMapper, RedisTemplate<String, Product> redisTemplate) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Product createProduct(Product productDomain) {
        return this.createOrUpdate(productDomain);
    }

    @Override
    public Product updateProduct(Product productDomain) {
        return this.createOrUpdate(productDomain);
    }

    @Override
    @CacheEvict(value = "products", allEntries = true)
    public void deleteProduct(Product productDomain) {
        this.productRepository.delete(this.productMapper.toProductDB(productDomain));
        this.hashOperations.delete("products", productDomain.getIdproduto());
    }

    @Override
    public List<Product> getAllProducts() {
        return this.hashOperations.values("products");
    }

    @Override
    public Product getProductById(int idproduto) {
        return this.hashOperations.get("products", idproduto);
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        return this.hashOperations.values("products")
                .stream().filter(product -> product.getCategoria().equals(category)).toList();
    }

    @Override
    public List<Product> getProductByIsPromotion(Boolean isPromotion) {
        return this.hashOperations.values("products")
                .stream().filter(product -> product.getEnablePromotions().equals(isPromotion)).toList();
    }

    private Product createOrUpdate(Product productDomain) {
        ProductDB productDB = this.productMapper.toProductDB(productDomain);
        this.productRepository.save(productDB);
        Product product = this.productMapper.toProduct(productDB);
        this.hashOperations.put("products", product.getIdproduto(), product);
        return product;
    }
}
