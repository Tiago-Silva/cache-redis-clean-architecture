package br.com.cacheredis.infrastructure.repositories;

import br.com.cacheredis.infrastructure.db.entitydb.ProductDB;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductDB, String> {

    ProductDB findByIdproduto(int idproduto);
    List<ProductDB> findByCategoria(String category);
    List<ProductDB> findByEnablePromotions(Boolean isPromotion);
}
