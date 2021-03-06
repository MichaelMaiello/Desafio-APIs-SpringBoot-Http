package com.qintess.desafio.entities.enums;

public enum PedidoStatus {
	
	AGUARDANDO_PAGAMNETO(1),
	PAGO(2),
	ENVIADO(3),
	ENTRGUE(4),
	CANCELADO(5);
	
	private int codigo;
	
	private PedidoStatus(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static PedidoStatus valueOf(int codigo) {
		for(PedidoStatus valor : PedidoStatus.values()) {
			if (valor.getCodigo() == codigo) {
				return valor;
			}
		}
		throw new IllegalArgumentException("Código de Status de pedido invalido! ");
	}
}


