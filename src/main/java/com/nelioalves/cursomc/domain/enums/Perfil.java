package com.nelioalves.cursomc.domain.enums;

import java.util.stream.Stream;

public enum Perfil {

    ADMIN(1, "Admin", "ROLE_ADMIN"),
    CLIENTE(2, "Cliente", "ROLE_CLIENT");

    private Integer codigo;
    private String descricao;
    private String role;

    Perfil(Integer codigo, String descricao, String role) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.role = role;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getRole() {
        return role;
    }

    public static Perfil of(Integer codigo) {
        return Stream.of(Perfil.values())
                .filter(estadoPagamento -> estadoPagamento.getCodigo().equals(codigo))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
