package br.com.cacheredis.infrastructure.db.entitydb;
import br.com.cacheredis.domain.entity.Product;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idproduto")
public class ProductDB {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idproduto;

    private String nome;

    private String descricao;

    private BigDecimal valor;

    private String categoria;

    private Boolean status;

    @Column(name = "url_image")
    private String urlImage;

    @Column(name = "enable_promotions")
    private Boolean enablePromotions;

    public ProductDB(Product product) {
        this.idproduto = product.getIdproduto();
        this.nome = product.getNome();
        this.descricao = product.getDescricao();
        this.valor = product.getValor();
        this.categoria = product.getCategoria();
        this.status = product.getStatus();
        this.urlImage = product.getUrlImage();
        this.enablePromotions = product.getEnablePromotions();
    }
}
