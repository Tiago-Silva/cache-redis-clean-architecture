package br.com.cacheredis.infrastructure.config;

import br.com.cacheredis.application.gateways.ProductGateway;
import br.com.cacheredis.application.usecases.ProductInteractor;
import br.com.cacheredis.domain.entity.Product;
import br.com.cacheredis.infrastructure.DTOMapper.ProductDTOMapper;
import br.com.cacheredis.infrastructure.gateways.ProductMapper;
import br.com.cacheredis.infrastructure.gateways.ProductRepositoryGateway;
import br.com.cacheredis.infrastructure.repositories.ProductRepository;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching
public class ProductConfig {

    @Bean
    ProductInteractor productInteractor(ProductGateway productGateway) {
        return new ProductInteractor(productGateway);
    }

    @Bean
    ProductGateway productGateway(ProductRepository productRepository, ProductMapper productMapper, RedisTemplate<String, Product> redisTemplate) {
        return new ProductRepositoryGateway(productRepository, productMapper, redisTemplate);
    }

    @Bean
    ProductMapper productMapper() {
        return new ProductMapper();
    }

    @Bean
    ProductDTOMapper productDTOMapper() {
        return new ProductDTOMapper();
    }
}
