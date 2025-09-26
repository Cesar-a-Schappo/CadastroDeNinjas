package dev.Java10x.CadastroDeNinjas.Missions;

import dev.Java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missions")
public class MissionsController {

    private MissionsService missionsService;

    public MissionsController(MissionsService missionsService) {
        this.missionsService = missionsService;
    }

    // Post -- Mandar uma requisicao para criar as missoes
    @PostMapping("/create")
    public ResponseEntity<String> createMission(@RequestBody MissionsDTO mission) {
        MissionsDTO newMission = missionsService.createMission(mission);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missao criada com sucesso: " + newMission.getName() + " (ID): " + newMission.getId());
    }

    // Get -- Mandar uma requisicao para mostrar as missoes
    @GetMapping("/list")
    public ResponseEntity<List<MissionsDTO>> listMissions() {
        List<MissionsDTO> missions = missionsService.listMissions();
        return ResponseEntity.ok(missions);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> listMissionById(@PathVariable Long id) {
        MissionsDTO mission = missionsService.listMissionById(id);
        if (mission != null) {
            return ResponseEntity.ok(mission);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao de ID: " + id + " nao encontrada.");
        }
    }

    // Put -- Mandar uma requisicao para alterar as missoes
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMission(@PathVariable Long id, @RequestBody MissionsDTO updatedMission) {
        MissionsDTO mission = missionsService.updateMission(id, updatedMission);
        if (mission != null) {
            return ResponseEntity.ok(mission);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao de ID: " + id + " nao encontrada.");
        }
    }

    // delete -- Mandar uma requisicao para deletar as missoes
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMissionById(@PathVariable Long id) {
        if (missionsService.listMissionById(id) != null) {
            missionsService.deleteMissionById(id);
            return ResponseEntity.ok("Missao com ID: " + id + " deletada com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao com ID: " + id + " nao encontrada.");
        }
    }

}
