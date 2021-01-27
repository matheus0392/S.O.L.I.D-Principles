package dev.msnascimento.liskov.service.promotion;

import dev.msnascimento.liskov.model.Cargo;
import dev.msnascimento.liskov.model.Funcionario;
import dev.msnascimento.liskov.ValidacaoException;

public class PromocaoService {

	public void promover(Funcionario funcionario, boolean metaBatida) {
		Cargo cargoAtual = funcionario.getCargo();
		if (Cargo.GERENTE == cargoAtual) {
			throw new ValidacaoException("Gerentes não podem ser promovidos");
		}

		if (metaBatida) {
			Cargo novoCargo = cargoAtual.proximoCargo();
			funcionario.promover(novoCargo);
		}else {
			throw new ValidacaoException("Funcionário não bateu a meta");
		}
	}
}
