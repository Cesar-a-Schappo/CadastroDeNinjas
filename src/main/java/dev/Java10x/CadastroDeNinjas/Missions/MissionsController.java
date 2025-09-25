package dev.Java10x.CadastroDeNinjas.Missions;

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
    public MissionsDTO createMission(@RequestBody MissionsDTO mission) {
        return missionsService.createMission(mission);
    }

    // Get -- Mandar uma requisicao para mostrar as missoes
    @GetMapping("/list")
    public List<MissionsDTO> listMissions() {
        return missionsService.listMissions();
    }

    @GetMapping("/list/{id}")
    public MissionsDTO listMissionById(@PathVariable Long id) {
        return missionsService.listMissionById(id);
    }

    // Put -- Mandar uma requisicao para alterar as missoes
    @PutMapping("/update/{id}")
    public MissionsDTO updateMission(@PathVariable Long id, @RequestBody MissionsDTO updatedMission) {
        return missionsService.updateMission(id, updatedMission);
    }

    // delete -- Mandar uma requisicao para deletar as missoes
    @DeleteMapping("/delete/{id}")
    public void deleteMissionById(@PathVariable Long id) {
        missionsService.deleteMissionById(id);
    }

}
