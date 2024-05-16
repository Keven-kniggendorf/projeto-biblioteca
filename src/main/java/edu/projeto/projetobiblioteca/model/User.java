package edu.projeto.projetobiblioteca.model;

import edu.projeto.projetobiblioteca.userRole.UserRoles;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String email;
    private String senha;
    private UserRoles roles;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.roles == UserRoles.ADMIN){ return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_CLIENT"));
        }else {
            return List.of(new SimpleGrantedAuthority("ROLE_CLIENT"));
        }
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        // Aqui você pode implementar lógica para verificar se a conta não expirou
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Aqui você pode implementar lógica para verificar se a conta não está bloqueada
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Aqui você pode implementar lógica para verificar se as credenciais não expiraram
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Aqui você pode implementar lógica para verificar se o usuário está habilitado
        return true;
    }



    public User(String email, String senha, UserRoles roles){
        super();
        this.email = email;
        this.senha = senha;
        this.roles = roles;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
