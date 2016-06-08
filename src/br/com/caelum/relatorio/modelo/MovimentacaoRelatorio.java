package br.com.caelum.relatorio.modelo;

import java.math.BigDecimal;
import java.util.Date;

public class MovimentacaoRelatorio {

	private Movimentacao movimentacao;

	public MovimentacaoRelatorio(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}

	public Integer getId() {
		return movimentacao.getId();
	}

	public String getDescricao() {
		return movimentacao.getDescricao();
	}

	public Date getData() {
		return movimentacao.getData().getTime();
	}

	public BigDecimal getValor() {
		return movimentacao.getValor();
	}

	public String getTipoMovimentacao() {
		return movimentacao.getTipoMovimentacao().name();
	}

}
