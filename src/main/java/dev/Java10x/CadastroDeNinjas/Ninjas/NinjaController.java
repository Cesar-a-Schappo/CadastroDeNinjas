package dev.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Essa e a minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/create")
    public ResponseEntity<String> createNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO newNinja = ninjaService.createNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + newNinja.getName() + " (ID): " + newNinja.getId());
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/list")
    public ResponseEntity<List<NinjaDTO>> listAllNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listAllNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/list/{id}")
    public ResponseEntity<?> listNinjaById(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listNinjaById(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID: " + id + " nao encontrado.");
        }
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateNinjaById(@PathVariable Long id, @RequestBody NinjaDTO updatedNinja) {
        NinjaDTO ninja = ninjaService.updateNinja(id, updatedNinja);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID: " + id + " nao encontrado.");
        }
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNinjaById(@PathVariable Long id) {
        if (ninjaService.listNinjaById(id) != null) {
            ninjaService.deleteNinjaById(id);
            return ResponseEntity.ok("Ninja com o ID: " + id + " deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID: " + id + " nao encontrado.");
        }
    }

}
