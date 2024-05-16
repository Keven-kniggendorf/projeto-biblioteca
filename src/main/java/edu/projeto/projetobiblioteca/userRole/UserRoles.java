package edu.projeto.projetobiblioteca.userRole;

public enum UserRoles {

    ADMIN("ADMIN"),
    CLIENT("CLIENT");

    private final String role;

UserRoles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

}
