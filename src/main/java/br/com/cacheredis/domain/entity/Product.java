package br.com.cacheredis.domain.entity;

import br.com.cacheredis.application.dto.ProductRequestDTO;
import br.com.cacheredis.application.dto.ProductResponseDTO;
import br.com.cacheredis.infrastructure.db.entitydb.ProductDB;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idproduto")
public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int idproduto;

    private String nome;

    private String descricao;

    private BigDecimal valor;

    private String categoria;

    private Boolean status;

    private String urlImage;

    private Boolean enablePromotions;

    public Product(ProductDB productDB) {
        this.idproduto = productDB.getIdproduto();
        this.nome = productDB.getNome();
        this.descricao = productDB.getDescricao();
        this.valor = productDB.getValor();
        this.categoria = productDB.getCategoria();
        this.status = productDB.getStatus();
        this.urlImage = productDB.getUrlImage();
        this.enablePromotions = productDB.getEnablePromotions();
    }

    public Product(ProductRequestDTO requestDTO) {
        this.nome = requestDTO.nome();
        this.descricao = requestDTO.descricao();
        this.valor = requestDTO.valor();
        this.categoria = requestDTO.categoria();
        this.status = requestDTO.status();
        this.urlImage = requestDTO.urlImage();
        this.enablePromotions = requestDTO.enablePromotions();
    }

    public Product(ProductResponseDTO responseDTO) {
        this.idproduto = responseDTO.idproduto();
        this.nome = responseDTO.nome();
        this.descricao = responseDTO.descricao();
        this.valor = responseDTO.valor();
        this.categoria = responseDTO.categoria();
        this.status = responseDTO.status();
        this.urlImage = responseDTO.urlImage();
        this.enablePromotions = responseDTO.enablePromotions();
    }
}
