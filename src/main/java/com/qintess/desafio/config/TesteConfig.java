package com.qintess.desafio.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.qintess.desafio.entities.CasaShow;
import com.qintess.desafio.entities.Cliente;
import com.qintess.desafio.entities.Evento;
import com.qintess.desafio.entities.ItemPedido;
import com.qintess.desafio.entities.Pagamento;
import com.qintess.desafio.entities.Pedido;
import com.qintess.desafio.entities.enums.PedidoStatus;
import com.qintess.desafio.repositories.CasaShowRepository;
import com.qintess.desafio.repositories.ClienteRepository;
import com.qintess.desafio.repositories.EventoRepository;
import com.qintess.desafio.repositories.ItemPedidoRepository;
import com.qintess.desafio.repositories.PedidoRepository;

@Configuration
@Profile("teste")
public class TesteConfig implements CommandLineRunner{
	
	//injeção de dependência
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CasaShowRepository casaShowRepository;
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
		
	

	@Override
	public void run(String... args) throws Exception {


		Cliente cliente1 = new Cliente(null, "Michael", "michael@.com.", "12341234", "123456");
		Cliente cliente2 = new Cliente(null, "Maria", "maria@.com", "99999999", "987654");
		//Salvar no banco
		clienteRepository.saveAll(Arrays.asList(cliente1));
		clienteRepository.saveAll(Arrays.asList(cliente2));
		
		
		Pedido pedido1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO, cliente1);
		Pedido pedido2 = new Pedido(null, Instant.parse("2019-04-03T10:53:07Z"), PedidoStatus.AGUARDANDO_PAGAMNETO, cliente2);
		Pedido pedido3 = new Pedido(null, Instant.parse("2019-03-15T09:53:07Z"), PedidoStatus.AGUARDANDO_PAGAMNETO, cliente1);
		//Salvar no banco
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2, pedido3));
		
		
		CasaShow casaShow1 = new CasaShow(null, "The wall", "13 de maio", 200, "98769876", "thewall.com.br");
		CasaShow casaShow2 = new CasaShow(null, "The wall", "13 de maio", 200, "98769876", "thewall.com.br");
		CasaShow casaShow3 = new CasaShow(null, "The wall", "13 de maio", 200, "98769876", "thewall.com.br");
		//Salvar no banco
		casaShowRepository.saveAll(Arrays.asList(casaShow1, casaShow2, casaShow3));
		
		
		Evento evento1 = new Evento(null, "cover", "cover", Instant.parse("2020-10-20T21:30:00Z"), 170, 100.00);
		Evento evento2 = new Evento(null, "cover", "cover", Instant.parse("2020-10-20T21:30:00Z"), 170, 100.00);
		Evento evento3 = new Evento(null, "cover", "cover", Instant.parse("2020-10-20T21:30:00Z"), 170, 100.00);
		Evento evento4 = new Evento(null, "cover", "cover", Instant.parse("2020-10-20T21:30:00Z"), 170, 100.00);
		Evento evento5 = new Evento(null, "cover", "cover", Instant.parse("2020-10-20T21:30:00Z"), 170, 100.00);
		//Salvar no banco
		eventoRepository.saveAll(Arrays.asList(evento1, evento2,evento3, evento4, evento5));
		
		evento1.getCasas().add(casaShow2);
		evento2.getCasas().add(casaShow1);
		evento2.getCasas().add(casaShow3);
		evento3.getCasas().add(casaShow3);
		evento4.getCasas().add(casaShow3);
		evento5.getCasas().add(casaShow2);
		//Salvar no banco
		eventoRepository.saveAll(Arrays.asList(evento1,evento2,evento3,evento4, evento5));
		
		
		ItemPedido ip1 = new ItemPedido(pedido1, evento1, 2, evento1.getPreco());
		ItemPedido ip2 = new ItemPedido(pedido1, evento3, 1, evento4.getPreco());
		ItemPedido ip3 = new ItemPedido(pedido2, evento3, 2, evento1.getPreco());
		ItemPedido ip4 = new ItemPedido(pedido3, evento5, 2, evento5.getPreco());
		//salvar no banco
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3, ip4));
		
		
		Pagamento pagamento1 = new Pagamento(null, Instant.parse("2020-10-20T23:30:00Z"), pedido1);
		pedido1.setPagemento(pagamento1);
		//salvar no banco
		pedidoRepository.save(pedido1);
		
	}
}
