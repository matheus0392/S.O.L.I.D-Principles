package dev.msnascimento.open.service;

import java.math.BigDecimal;
import java.util.List;

import dev.msnascimento.open.model.Funcionario;

public class ReajusteService {

	private List<ValidacaoReajuste> validacoes;

	public ReajusteService(List<ValidacaoReajuste> validacoes) {
		super();
		this.validacoes = validacoes;
	}

	public void reajustarSalarioFuncionario(Funcionario funcionario, BigDecimal aumento) {
		this.validacoes.forEach(v -> v.validar(funcionario, aumento));

		BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
	}
}
