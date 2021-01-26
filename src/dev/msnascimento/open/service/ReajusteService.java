package dev.msnascimento.open.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import dev.msnascimento.open.ValidacaoException;
import dev.msnascimento.open.model.Funcionario;

public class ReajusteService {

	public void reajustarSalarioFuncionario(Funcionario funcionario, BigDecimal aumento) {
		BigDecimal salario = funcionario.getSalario();
		BigDecimal percentualReajuste = aumento.divide(salario, RoundingMode.HALF_UP);
		if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
		}
		BigDecimal salarioReajustado = salario.add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
	}
}
