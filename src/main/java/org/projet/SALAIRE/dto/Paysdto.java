package org.projet.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Paysdto {
	private Long IdPays;
	private String NomPays;

	private String LibelleNationnalite;

}
