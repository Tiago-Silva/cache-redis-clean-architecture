package br.com.cacheredis.infrastructure.controller;

import br.com.cacheredis.application.dto.ProductRequestDTO;
import br.com.cacheredis.application.dto.ProductResponseDTO;
import br.com.cacheredis.application.usecases.ProductInteractor;
import br.com.cacheredis.domain.entity.Product;
import br.com.cacheredis.infrastructure.DTOMapper.ProductDTOMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProdutcController {

    private final ProductInteractor productInteractor;
    private final ProductDTOMapper mapper;
    public ProdutcController(ProductInteractor productInteractor, ProductDTOMapper mapper) {
        this.productInteractor = productInteractor;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(@RequestBody ProductRequestDTO requestDTO) {
        Product product = this.mapper.requestDTOToDomainObject(requestDTO);
        return ResponseEntity.ok(this.mapper.domainObjectToResponseDTO(this.productInteractor.createProduct(product)));
    }

    @PutMapping
    public ResponseEntity<ProductResponseDTO> update(@RequestBody ProductResponseDTO responseDTO) {
        Product product = this.mapper.responseDTOToDomainObject(responseDTO);
        return ResponseEntity.ok(this.mapper.domainObjectToResponseDTO(this.productInteractor.updateProduct(product)));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody ProductResponseDTO responseDTO) {
        this.productInteractor.deleteProduct(this.mapper.responseDTOToDomainObject(responseDTO));
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        return ResponseEntity.ok(
            this.productInteractor.getAllProducts().stream().map(this.mapper::domainObjectToResponseDTO).toList()
        );
    }

    @GetMapping("/{idproduto}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable("idproduto") int idproduto) {
        return ResponseEntity.ok(
            this.mapper.domainObjectToResponseDTO(this.productInteractor.getProductById(idproduto))
        );
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductResponseDTO>> getProductByCategory(@PathVariable("category") String category) {
        return ResponseEntity.ok(
            this.productInteractor.getProductByCategory(category).stream().map(this.mapper::domainObjectToResponseDTO).toList()
        );
    }

    @GetMapping("/promotion/{isPromotion}")
    public ResponseEntity<List<ProductResponseDTO>> getProductByIsPromotion(@PathVariable("isPromotion") Boolean isPromotion) {
        return ResponseEntity.ok(
            this.productInteractor.getProductByIsPromotion(isPromotion).stream().map(this.mapper::domainObjectToResponseDTO).toList()
        );
    }
}
