package dev.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/welcome")
    public String boasVindas() {
        return "Essa e a minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/create")
    public String criarNinja() {
        return "Ninja criado";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/all")
    public String mostrarTodosOsNinja() {
        return "Mostrar todo os ninjas";
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/allID")
    public String mostrarTodosOsNinjaPorId() {
        return "Mostrar ninjas por ID";
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/changeID")
    public String alterarNinjaPorId() {
        return "Alterar ninja por id";
    }

    // Deletar nina (DELETE)
    @DeleteMapping("/deleteID")
    public String deletarNinjaPorId() {
        return "Ninja deletado por id";
    }

}
