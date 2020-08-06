package com.nelioalves.cursomc.services;

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

        Produto p12 = new Produto(null, "Produto 12", new BigDecimal(10.00));
        Produto p13 = new Produto(null, "Produto 13", new BigDecimal(10.00));
        Produto p14 = new Produto(null, "Produto 14", new BigDecimal(10.00));
        Produto p15 = new Produto(null, "Produto 15", new BigDecimal(10.00));
        Produto p16 = new Produto(null, "Produto 16", new BigDecimal(10.00));
        Produto p17 = new Produto(null, "Produto 17", new BigDecimal(10.00));
        Produto p18 = new Produto(null, "Produto 18", new BigDecimal(10.00));
        Produto p19 = new Produto(null, "Produto 19", new BigDecimal(10.00));
        Produto p20 = new Produto(null, "Produto 20", new BigDecimal(10.00));
        Produto p21 = new Produto(null, "Produto 21", new BigDecimal(10.00));
        Produto p22 = new Produto(null, "Produto 22", new BigDecimal(10.00));
        Produto p23 = new Produto(null, "Produto 23", new BigDecimal(10.00));
        Produto p24 = new Produto(null, "Produto 24", new BigDecimal(10.00));
        Produto p25 = new Produto(null, "Produto 25", new BigDecimal(10.00));
        Produto p26 = new Produto(null, "Produto 26", new BigDecimal(10.00));
        Produto p27 = new Produto(null, "Produto 27", new BigDecimal(10.00));
        Produto p28 = new Produto(null, "Produto 28", new BigDecimal(10.00));
        Produto p29 = new Produto(null, "Produto 29", new BigDecimal(10.00));
        Produto p30 = new Produto(null, "Produto 30", new BigDecimal(10.00));
        Produto p31 = new Produto(null, "Produto 31", new BigDecimal(10.00));
        Produto p32 = new Produto(null, "Produto 32", new BigDecimal(10.00));
        Produto p33 = new Produto(null, "Produto 33", new BigDecimal(10.00));
        Produto p34 = new Produto(null, "Produto 34", new BigDecimal(10.00));
        Produto p35 = new Produto(null, "Produto 35", new BigDecimal(10.00));
        Produto p36 = new Produto(null, "Produto 36", new BigDecimal(10.00));
        Produto p37 = new Produto(null, "Produto 37", new BigDecimal(10.00));
        Produto p38 = new Produto(null, "Produto 38", new BigDecimal(10.00));
        Produto p39 = new Produto(null, "Produto 39", new BigDecimal(10.00));
        Produto p40 = new Produto(null, "Produto 40", new BigDecimal(10.00));
        Produto p41 = new Produto(null, "Produto 41", new BigDecimal(10.00));
        Produto p42 = new Produto(null, "Produto 42", new BigDecimal(10.00));
        Produto p43 = new Produto(null, "Produto 43", new BigDecimal(10.00));
        Produto p44 = new Produto(null, "Produto 44", new BigDecimal(10.00));
        Produto p45 = new Produto(null, "Produto 45", new BigDecimal(10.00));
        Produto p46 = new Produto(null, "Produto 46", new BigDecimal(10.00));
        Produto p47 = new Produto(null, "Produto 47", new BigDecimal(10.00));
        Produto p48 = new Produto(null, "Produto 48", new BigDecimal(10.00));
        Produto p49 = new Produto(null, "Produto 49", new BigDecimal(10.00));
        Produto p50 = new Produto(null, "Produto 50", new BigDecimal(10.00));
        cat1.getProdutos().addAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
                p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
                p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));

        p12.getCategorias().add(cat1);
        p13.getCategorias().add(cat1);
        p14.getCategorias().add(cat1);
        p15.getCategorias().add(cat1);
        p16.getCategorias().add(cat1);
        p17.getCategorias().add(cat1);
        p18.getCategorias().add(cat1);
        p19.getCategorias().add(cat1);
        p20.getCategorias().add(cat1);
        p21.getCategorias().add(cat1);
        p22.getCategorias().add(cat1);
        p23.getCategorias().add(cat1);
        p24.getCategorias().add(cat1);
        p25.getCategorias().add(cat1);
        p26.getCategorias().add(cat1);
        p27.getCategorias().add(cat1);
        p28.getCategorias().add(cat1);
        p29.getCategorias().add(cat1);
        p30.getCategorias().add(cat1);
        p31.getCategorias().add(cat1);
        p32.getCategorias().add(cat1);
        p33.getCategorias().add(cat1);
        p34.getCategorias().add(cat1);
        p35.getCategorias().add(cat1);
        p36.getCategorias().add(cat1);
        p37.getCategorias().add(cat1);
        p38.getCategorias().add(cat1);
        p39.getCategorias().add(cat1);
        p40.getCategorias().add(cat1);
        p41.getCategorias().add(cat1);
        p42.getCategorias().add(cat1);
        p43.getCategorias().add(cat1);
        p44.getCategorias().add(cat1);
        p45.getCategorias().add(cat1);
        p46.getCategorias().add(cat1);
        p47.getCategorias().add(cat1);
        p48.getCategorias().add(cat1);
        p49.getCategorias().add(cat1);
        p50.getCategorias().add(cat1);

        produtoRepository.saveAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
                p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
                p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));

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
