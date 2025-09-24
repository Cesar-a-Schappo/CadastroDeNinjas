package dev.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Essa e a minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/create")
    public NinjaModel createNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.createNinja(ninja);
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/list")
    public List<NinjaModel> listAllNinjas() {
        return ninjaService.listAllNinjas();
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/list/{id}")
    public NinjaModel listNinjaById(@PathVariable Long id) {
        return ninjaService.listNinjaById(id);
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/update/{id}")
    public NinjaModel updateNinjaById(@PathVariable Long id, @RequestBody NinjaModel updatedNinja) {
        return ninjaService.updateNinja(id, updatedNinja);
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/delete/{id}")
    public void deleteNinjaById(@PathVariable Long id) {
        ninjaService.deleteNinjaById(id);
    }

}
