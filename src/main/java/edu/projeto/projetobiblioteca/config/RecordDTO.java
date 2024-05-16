package edu.projeto.projetobiblioteca.config;

import edu.projeto.projetobiblioteca.userRole.UserRoles;

public record RecordDTO(String email, String senha, UserRoles role) {
}
