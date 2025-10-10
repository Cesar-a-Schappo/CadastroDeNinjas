package dev.Java10x.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
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
    @Operation(summary = "Welcome message", description = "This route shows a welcome message to who access it")
    public String welcome() {
        return "This is my first message in this route";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/create")
    @Operation(summary = "Creates a new ninja", description = "Route creates a new ninja and inserts it into the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja successfully created"),
            @ApiResponse(responseCode = "400", description = "Ninja creation error")
    })
    public ResponseEntity<String> createNinja(
            @Parameter(description = "User sends the ninja data on the request body")
            @RequestBody NinjaDTO ninja) {
        NinjaDTO newNinja = ninjaService.createNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + newNinja.getName() + " (ID): " + newNinja.getId());
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/list")
    @Operation(summary = "Lists all ninjas", description = "Route that lists all ninjas on the database")
    public ResponseEntity<List<NinjaDTO>> listAllNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listAllNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/list/{id}")
    @Operation(summary = "Lists ninjas by id", description = "Route lists a ninja by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja successfully found"),
            @ApiResponse(responseCode = "404", description = "Ninja not found")
    })
    public ResponseEntity<?> listNinjaById(
            @Parameter(description = "User sends the id on the request path")
            @PathVariable Long id) {
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
    @Operation(summary = "Updates a ninja by id", description = "Route updates a ninja by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja successfully updated"),
            @ApiResponse(responseCode = "404", description = "Ninja not found")
    })
    public ResponseEntity<?> updateNinjaById(
            @Parameter(description = "User sends the id on the request path")
            @PathVariable Long id,
            @Parameter(description = "User sends the updated ninja data on the request body")
            @RequestBody NinjaDTO updatedNinja) {
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
    @Operation(summary = "Deletes a ninja by id", description = "Deletes a ninja on the database by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Ninja not found")
    })
    public ResponseEntity<String> deleteNinjaById(
            @Parameter(description = "User sends the id on the request path")
            @PathVariable Long id) {
        if (ninjaService.listNinjaById(id) != null) {
            ninjaService.deleteNinjaById(id);
            return ResponseEntity.ok("Ninja com o ID: " + id + " deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID: " + id + " nao encontrado.");
        }
    }

}
