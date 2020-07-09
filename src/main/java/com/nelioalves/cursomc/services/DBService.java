package com.nelioalves.cursomc.services;

import com.nelioalves.cursomc.CursomcApplication;
import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.domain.Endereco;
import com.nelioalves.cursomc.domain.Estado;
import com.nelioalves.cursomc.domain.ItemPedido;
import com.nelioalves.cursomc.domain.Pagamento;
import com.nelioalves.cursomc.domain.PagamentoComBoleto;
import com.nelioalves.cursomc.domain.PagamentoComCartao;
import com.nelioalves.cursomc.domain.Pedido;
import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.domain.enums.EstadoPagamento;
import com.nelioalves.cursomc.domain.enums.Perfil;
import com.nelioalves.cursomc.domain.enums.TipoCliente;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.repositories.CidadeRepository;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.repositories.EnderecoRepository;
import com.nelioalves.cursomc.repositories.EstadoRepository;
import com.nelioalves.cursomc.repositories.ItemPedidoRepository;
import com.nelioalves.cursomc.repositories.PagamentoRepository;
import com.nelioalves.cursomc.repositories.PedidoRepository;
import com.nelioalves.cursomc.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void instantiateTestDatabase() {
        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");
        Categoria cat3 = new Categoria(null, "Cama, Mesa e Banho");
        Categoria cat4 = new Categoria(null, "Eletrônicos");
        Categoria cat5 = new Categoria(null, "Jardinagem");
        Categoria cat6 = new Categoria(null, "Decoração");
        Categoria cat7 = new Categoria(null, "Perfumaria");
        Categoria cat8 = new Categoria(null, "Ferramentas");
        Categoria cat9 = new Categoria(null, "Utilidades");
        Categoria cat10 = new Categoria(null, "Diversos");

        Produto prod1 = new Produto(null, "Computador", new BigDecimal("2000.00"));
        Produto prod2 = new Produto(null, "Impressora", new BigDecimal("800.00"));
        Produto prod3 = new Produto(null, "Mouse", new BigDecimal("80.00"));
        Produto prod4 = new Produto(null, "Mesa de escritório", new BigDecimal("300.00"));
        Produto prod5 = new Produto(null, "Toalha", new BigDecimal("50.00"));
        Produto prod6 = new Produto(null, "Colcha", new BigDecimal("200.00"));
        Produto prod7 = new Produto(null, "TV True Color", new BigDecimal("1200.00"));
        Produto prod8 = new Produto(null, "Roçadeira", new BigDecimal("800.00"));
        Produto prod9 = new Produto(null, "Abajour", new BigDecimal("100.00"));
        Produto prod10 = new Produto(null, "Pendente", new BigDecimal("180.00"));
        Produto prod11 = new Produto(null, "Porta Shampoo", new BigDecimal("90.00"));

        cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
        cat2.getProdutos().addAll(Arrays.asList(prod2, prod4));
        cat3.getProdutos().addAll(Arrays.asList(prod5, prod6));
        cat4.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3, prod7));
        cat5.getProdutos().addAll(Arrays.asList(prod8));
        cat6.getProdutos().addAll(Arrays.asList(prod9, prod10));
        cat7.getProdutos().addAll(Arrays.asList(prod11));

        prod1.setCategorias(Arrays.asList(cat1));
        prod2.setCategorias(Arrays.asList(cat1, cat2));
        prod3.setCategorias(Arrays.asList(cat1));
        prod4.setCategorias(Arrays.asList(cat2));
        prod5.setCategorias(Arrays.asList(cat3));
        prod6.setCategorias(Arrays.asList(cat3));
        prod7.setCategorias(Arrays.asList(cat4));
        prod8.setCategorias(Arrays.asList(cat5));
        prod9.setCategorias(Arrays.asList(cat6));
        prod10.setCategorias(Arrays.asList(cat6));
        prod11.setCategorias(Arrays.asList(cat7));


        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10));
        produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5, prod6, prod7, prod8, prod9, prod10, prod11));

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade cid1 = new Cidade(null, "Uberlândia", est1);
        Cidade cid2 = new Cidade(null, "São Paulo", est2);
        Cidade cid3 = new Cidade(null, "Campinas", est2);

        est1.setCidades(Arrays.asList(cid1));
        est2.setCidades(Arrays.asList(cid2, cid3));

        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

        Cliente cli1 = new Cliente(null, "Maria Silva", "joao_cesar_pereira@hotmail.com", "36378912377", TipoCliente.PESSOAFISICA, encoder.encode("12345"));
        cli1.getTelefones().addAll(Arrays.asList("27363323", "993838393"));

        Cliente cli2 = new Cliente(null, "Joao Cesar", "joao.cesar@gmail.com", "76144315101", TipoCliente.PESSOAFISICA, encoder.encode("abc123"));
        cli2.addPerfil(Perfil.ADMIN);
        cli2.getTelefones().addAll(Arrays.asList("37363323", "999938393"));

        Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, cid1);
        Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "01777012", cli1, cid2);

        Endereco e3 = new Endereco(null, "Avenida Floriano", "2106", null, "Centro", "01777212", cli2, cid2);

        cli1.setEnderecos(Arrays.asList(e1, e2));
        cli2.setEnderecos(Arrays.asList(e3));

        clienteRepository.saveAll(Arrays.asList(cli1, cli2));
        enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));

        Pedido ped1 = new Pedido(null, LocalDateTime.of(2017,9, 30, 10,32), cli1, e1);
        Pedido ped2 = new Pedido(null, LocalDateTime.of(2017,10, 10, 19,35), cli1, e2);

        Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
        ped1.setPagamento(pagto1);

        Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, LocalDate.of(2017, 10, 20), null);
        ped2.setPagamento(pagto2);

        cli1.setPedidos(Arrays.asList(ped1, ped2));

        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
        pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

        ItemPedido ip1 = new ItemPedido(ped1, prod1, new BigDecimal("0.00"), 1, new BigDecimal("2000.00"));
        ItemPedido ip2 = new ItemPedido(ped1, prod3, new BigDecimal("0.00"), 2, new BigDecimal("80.00"));
        ItemPedido ip3 = new ItemPedido(ped2, prod2, new BigDecimal("100.00"), 1, new BigDecimal("800.00"));

        ped1.getItens().addAll(Arrays.asList(ip1, ip2));
        ped2.getItens().add(ip3);

        prod1.getItens().add(ip1);
        prod2.getItens().add(ip3);
        prod3.getItens().add(ip2);

        itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

    }
}
