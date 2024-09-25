package org.SchoolApp.Web.Controller.Impl;

import org.SchoolApp.Datas.Entity.ReferentielEntity;
import org.SchoolApp.Datas.Repository.ApprenantRepository;
import org.SchoolApp.Exceptions.ResourceNotFoundException;
import org.SchoolApp.Services.Interfaces.ApprenantService;
import org.SchoolApp.Web.Dtos.Mapper.ApprenantMapper;
import org.SchoolApp.Web.Dtos.Request.ApprenantRequestDto;
import org.SchoolApp.Web.Dtos.Response.ApprenantResponseDto;
import org.SchoolApp.Datas.Entity.ApprenantEntity;
import org.SchoolApp.Web.Dtos.Response.ReferentielResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/apprenants")
public class ApprenantController {

    @Autowired
    private ApprenantService apprenantService;

    @Autowired
    private ApprenantMapper apprenantMapper;

    @PostMapping
    public ResponseEntity<ApprenantResponseDto> createApprenant(@RequestBody ApprenantRequestDto apprenantRequestDto) {
        // Convert request DTO to entity
        ApprenantEntity apprenantEntity = apprenantMapper.toEntity(apprenantRequestDto);

        // Call the service layer to handle business logic
        ApprenantEntity savedApprenant = apprenantService.createApprenant(apprenantEntity);

        // Convert the saved entity to response DTO
        ApprenantResponseDto responseDto = apprenantMapper.toDto(savedApprenant);

        return ResponseEntity.ok(responseDto);
    }


//    // Endpoint to retrieve an apprenant by ID, including referentiel details
//    @GetMapping("/{id}")
//    public ApprenantResponseDto getApprenantById(
//            @PathVariable Long id) {
//
//        Optional<ApprenantEntity> apprenantOptional = ApprenantRepository.findById(id);
//
//        if (apprenantOptional.isPresent()) {
//            ApprenantEntity apprenant = apprenantOptional.get();
//            ApprenantResponseDto responseDto = apprenantMapper.toDto(apprenant);
//
//            // Récupérer les informations du référentiel et les mapper
//            ReferentielEntity referentiel = apprenant.getReferentiel();
//            if (referentiel != null) {
//                ReferentielResponseDto referentielDto = new ReferentielResponseDto();
//                referentielDto.setId(referentiel.getId());
//                referentielDto.setLibelle(referentiel.getLibelle());
//                referentielDto.setCode(referentiel.getCode());
//                referentielDto.setDescription(referentiel.getDescription());
//                referentielDto.setPhotoCouverture(referentiel.getPhotoCouverture());
//                referentielDto.setStatus(referentiel.getStatus().name()); // Assurez-vous que le statut est au format String
//                // Ajoutez les compétences si nécessaire
//                // referentielDto.setCompetences(referentiel.getCompetences());
//
//                responseDto.setReferentiel(referentielDto.getLibelle()); // ou utilisez referentielDto pour des données plus détaillées
//            }
//
//            return responseDto;
//        } else {
//            throw new ResourceNotFoundException("Apprenant non trouvé avec l'ID: " + id);
//        }
//    }
}
