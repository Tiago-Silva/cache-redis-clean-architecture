package br.com.cacheredis.application.dto;

import java.math.BigDecimal;

public record ProductRequestDTO(
    String nome,
    String descricao,
    BigDecimal valor,
    String categoria,
    Boolean status,
    String urlImage,
    Boolean enablePromotions) {
}
