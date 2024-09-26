package org.SchoolApp.Services.Impl;

import org.SchoolApp.Datas.Entity.Fonction; // Importer la classe Fonction
import org.SchoolApp.Datas.Entity.Role;
import org.SchoolApp.Datas.Entity.UserEntity;
import org.SchoolApp.Datas.Repository.FonctionRepository; // Importer le repository Fonction
import org.SchoolApp.Datas.Repository.RoleRepository;
import org.SchoolApp.Datas.Repository.UserRepository;
import org.SchoolApp.Web.Dtos.Request.LoginUserDto;
import org.SchoolApp.Web.Dtos.Request.RegisterUserDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final FonctionRepository fonctionRepository; // Ajouter le repository Fonction
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            RoleRepository roleRepository,
            FonctionRepository fonctionRepository, // Ajouter le repository dans le constructeur
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.fonctionRepository = fonctionRepository; // Initialiser le repository
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity signup(RegisterUserDto input) {
        // Vérifier si l'email existe déjà
        Optional<UserEntity> existingEmailUser = userRepository.findByEmail(input.getEmail());
        if (existingEmailUser.isPresent()) {
            throw new IllegalArgumentException("Un utilisateur avec cet email existe déjà.");
        }

        // Vérifier si le téléphone existe déjà
        Optional<UserEntity> existingPhoneUser = userRepository.findByTelephone(input.getTelephone());
        if (existingPhoneUser.isPresent()) {
            throw new IllegalArgumentException("Un utilisateur avec ce téléphone existe déjà.");
        }

        // Récupérer le rôle
        Role role = roleRepository.findById(input.getRoleId())
                .orElseThrow(() -> new IllegalArgumentException("Le rôle spécifié est introuvable."));

        // Récupérer la fonction
        Fonction fonction = fonctionRepository.findById(input.getFonctionId())
                .orElseThrow(() -> new IllegalArgumentException("La fonction spécifiée est introuvable."));

        // Créer un nouvel utilisateur
        UserEntity user = new UserEntity();
        user.setNom(input.getNom());
        user.setPrenom(input.getPrenom());
        user.setEmail(input.getEmail());
        user.setAdresse(input.getAdresse());
        user.setTelephone(input.getTelephone());
        user.setPhoto(input.getPhoto());
        user.setStatus(input.getStatus());
        user.setFonction(fonction); // Associer l'objet Fonction à l'utilisateur
        user.setRole(role); // Associer le rôle à l'utilisateur
        user.setPassword(passwordEncoder.encode(input.getPassword())); // Encoder le mot de passe

        return userRepository.save(user);
    }

    public UserEntity authenticate(LoginUserDto input) {
        // Authentifier l'utilisateur
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        // Récupérer l'utilisateur par email
        return userRepository.findByEmail(input.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Aucun utilisateur trouvé avec cet email."));
    }
}
