package dev.msnascimento.is.service.taxing;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ReajusteTributavel extends Reajuste {

	BigDecimal valorImpostoRenda();
}
