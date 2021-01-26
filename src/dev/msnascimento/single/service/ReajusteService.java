package dev.msnascimento.single.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import dev.msnascimento.single.ValidacaoException;
import dev.msnascimento.single.model.Funcionario;

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
