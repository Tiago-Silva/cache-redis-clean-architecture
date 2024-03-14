package br.com.cacheredis.infrastructure.DTOMapper;

import br.com.cacheredis.application.dto.ProductRequestDTO;
import br.com.cacheredis.application.dto.ProductResponseDTO;
import br.com.cacheredis.domain.entity.Product;

public class ProductDTOMapper {

    public ProductRequestDTO domainObjectToRequestDTO(Product domainObject) {
        return new ProductRequestDTO(
            domainObject.getNome(),
            domainObject.getDescricao(),
            domainObject.getValor(),
            domainObject.getCategoria(),
            domainObject.getStatus(),
            domainObject.getUrlImage(),
            domainObject.getEnablePromotions()
        );
    }

    public ProductResponseDTO domainObjectToResponseDTO(Product domainObject) {
        return new ProductResponseDTO(
            domainObject.getIdproduto(),
            domainObject.getNome(),
            domainObject.getDescricao(),
            domainObject.getValor(),
            domainObject.getCategoria(),
            domainObject.getStatus(),
            domainObject.getUrlImage(),
            domainObject.getEnablePromotions()
        );
    }

    public Product requestDTOToDomainObject(ProductRequestDTO requestDTO) {
        return new Product(requestDTO);
    }

    public Product responseDTOToDomainObject(ProductResponseDTO responseDTO) {
        return new Product(responseDTO);
    }
}
