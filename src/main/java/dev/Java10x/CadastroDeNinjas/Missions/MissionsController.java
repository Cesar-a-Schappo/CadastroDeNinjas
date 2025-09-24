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

    // Get -- Mandar uma requisicao para mostrar as missoes
    @GetMapping("/list")
    public List<MissionsModel> listMissions() {
        return missionsService.listMissions();
    }

    // Post -- Mandar uma requisicao para criar as missoes
    @PostMapping("/create")
    public MissionsModel createMission(@RequestBody MissionsModel mission) {
        return missionsService.createMission(mission);
    }

    // Put -- Mandar uma requisicao para alterar as missoes
    @PutMapping("/change")
    public String changeMission() {
        return "Missao alterada com sucesso";
    }

    // delete -- Mandar uma requisicao para deletar as missoes
    @DeleteMapping("/delete/{id}")
    public void deleteMissionById(@PathVariable Long id) {
        missionsService.deleteMissionById(id);
    }

}
