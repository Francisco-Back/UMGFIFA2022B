package com.umg.edu.UMGFIFA2022B.TSecurity.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.umg.edu.UMGFIFA2022B.entity.LigasEntity;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Usuario")
public class Usuario {
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String nombre;
    @NotNull
    @Column(unique = true)
    private String email;
    @NotNull
    private String avatar;
    @NotNull
    private String password;
    
    @OneToMany(mappedBy = "Usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<LigasEntity> ligas = new HashSet<>();
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    public Usuario() {
    }


	public Usuario(@NotNull String nombre,@NotNull String avatar, @NotNull String email, @NotNull String password) {
        this.nombre = nombre;
        this.avatar = avatar;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    

    public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public void setPassword(String password) {
        this.password = password;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
    public Set<LigasEntity> getLigas() {
        return ligas;
    }

    public void setLigas(Set<LigasEntity> ligas) {
        this.ligas = ligas;
    }
}