package dev.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Essa e a minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/create")
    public String createNinja() {
        return "Ninja criado";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/list")
    public String listAllNinjas() {
        return "Mostrar todo os ninjas";
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/listID")
    public String listNinjaById() {
        return "Mostrar ninjas por ID";
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/changeID")
    public String changeNinjaById() {
        return "Alterar ninja por id";
    }

    // Deletar nina (DELETE)
    @DeleteMapping("/deleteID")
    public String deleteNinjaById() {
        return "Ninja deletado por id";
    }

}
