package com.nelioalves.cursomc.domain.converters;

import com.nelioalves.cursomc.domain.enums.TipoCliente;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TipoClienteAttributeConverter implements AttributeConverter<TipoCliente, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TipoCliente tipoCliente) {
        if (tipoCliente == null) {
            return null;
        }
        return tipoCliente.getCodigo();
    }

    @Override
    public TipoCliente convertToEntityAttribute(Integer codigo) {
        if (codigo == null) {
            return null;
        }
        return TipoCliente.of(codigo);
    }
}
