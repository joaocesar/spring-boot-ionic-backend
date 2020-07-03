package com.nelioalves.cursomc.services;

import com.nelioalves.cursomc.domain.PagamentoComBoleto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BoletoService {
    public void preencherPagamentoComBoleto(PagamentoComBoleto boleto, LocalDateTime instanteDoPedido) {
        boleto.setDataVencimento(instanteDoPedido.toLocalDate().plusDays(7));
    }
}
