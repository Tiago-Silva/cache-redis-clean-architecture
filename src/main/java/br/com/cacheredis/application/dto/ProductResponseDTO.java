package br.com.cacheredis.application.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public record ProductResponseDTO(
    int idproduto,
    String nome,
    String descricao,
    BigDecimal valor,
    String categoria,
    Boolean status,
    String urlImage,
    Boolean enablePromotions
) implements Serializable {
}
