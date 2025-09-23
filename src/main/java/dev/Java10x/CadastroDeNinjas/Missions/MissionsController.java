package dev.Java10x.CadastroDeNinjas.Missions;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missions")
public class MissionsController {

    // Get -- Mandar uma requisicao para mostrar as missoes
    @GetMapping("/list")
    public String listMission() {
        return "Missoes listadas com sucesso";
    }

    // Post -- Mandar uma requisicao para criar as missoes
    @PostMapping("/create")
    public String createMission() {
        return "Missao criada com sucesso";
    }

    // Put -- Mandar uma requisicao para alterar as missoes
    @PutMapping("/change")
    public String changeMission() {
        return "Missao alterada com sucesso";
    }

    // delete -- Mandar uma requisicao para deletar as missoes
    @DeleteMapping("/delete")
    public String deleteMission() {
        return "Missao deletada com sucesso";
    }

}
