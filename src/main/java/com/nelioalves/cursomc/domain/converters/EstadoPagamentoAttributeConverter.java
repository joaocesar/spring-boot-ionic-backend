package com.nelioalves.cursomc.domain.converters;

import com.nelioalves.cursomc.domain.enums.EstadoPagamento;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class EstadoPagamentoAttributeConverter implements AttributeConverter<EstadoPagamento, Integer> {

    @Override
    public Integer convertToDatabaseColumn(EstadoPagamento estadoPagamento) {
        if (estadoPagamento == null) {
            return null;
        }
        return estadoPagamento.getCodigo();
    }

    @Override
    public EstadoPagamento convertToEntityAttribute(Integer codigo) {
        if (codigo == null) {
            return null;
        }
        return EstadoPagamento.of(codigo);
    }
}
