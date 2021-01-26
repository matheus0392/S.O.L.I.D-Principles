package dev.msnascimento.open.service;

import java.math.BigDecimal;

import dev.msnascimento.open.model.Funcionario;

public interface ValidacaoReajuste {

	public void validar(Funcionario funcionario, BigDecimal aumento);
}
