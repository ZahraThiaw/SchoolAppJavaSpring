package org.SchoolApp.Datas.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.SchoolApp.Datas.Enums.StatusEnum;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "user_entity")
@ToString
public class UserEntity extends EntityAbstract implements UserDetails{

    private String nom;
    private String prenom;
    private String adresse;

    @Column(unique = true, nullable = false)
    private String telephone; // Correction de la casse pour suivre la convention Java

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    private String photo;

    // Relation Many-to-One avec Role
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = true)  // Peut être nullable si l'utilisateur n'a pas toujours un rôle
    @JsonIgnore
    @ToString.Exclude
    private Role role;

    @ManyToOne
    @JoinColumn(name = "fonction_id", nullable = true)
    @JsonIgnore
    @ToString.Exclude
    private Fonction fonction;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private ApprenantEntity apprenant;

    @ManyToMany
    @JoinTable(
            name = "user_emargement",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "emargement_id")
    )
    @JsonIgnore
    private Set<EmargementEntity> emargements;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        UserEntity other = (UserEntity) obj;
        return super.equals(obj); // Repose sur l'égalité de l'id dans EntityAbstract
    }

    @Override
    public int hashCode() {
        return super.hashCode(); // Utilise le hashCode de EntityAbstract basé sur l'id
    }




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
