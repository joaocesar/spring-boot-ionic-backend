package com.nelioalves.cursomc.domain.enums;

import java.util.stream.Stream;

public enum TipoCliente {

    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    private Integer codigo;
    private String descricao;

    TipoCliente(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente of(Integer codigo) {
        return Stream.of(TipoCliente.values())
                    .filter(tipoCliente -> tipoCliente.getCodigo().equals(codigo))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
    }
}
