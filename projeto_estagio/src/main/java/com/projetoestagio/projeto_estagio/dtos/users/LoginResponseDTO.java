package com.projetoestagio.projeto_estagio.dtos.users;

public record LoginResponseDTO(String accessToken, Long expiresIn) {
	
	//ExpiresIn é para quantos segundos o seu token vai expirar
   //response é oque volta

}
