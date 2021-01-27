package dev.msnascimento.liskov.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import dev.msnascimento.open.ValidacaoException;
import dev.msnascimento.open.model.Funcionario;

public class ValidacaoPercentualReajuste implements ValidacaoReajuste {

	public void validar(Funcionario funcionario, BigDecimal aumento) {
		BigDecimal salario = funcionario.getSalario();
		BigDecimal percentualReajuste = aumento.divide(salario, RoundingMode.HALF_UP);
		if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
		}
	}
}
