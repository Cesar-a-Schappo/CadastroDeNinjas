package dev.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUI {

    private final NinjaService ninjaService;

    public NinjaControllerUI(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/list")
    public String listAllNinjas(Model model) {
        List<NinjaDTO> ninjas = ninjaService.listAllNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listNinjas"; // Tem que retornar o nome da pagina que renderiza
    }

    @GetMapping("/list/{id}")
    public String listNinjaById(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.listNinjaById(id);
        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "ninjaDetails";
        } else {
            model.addAttribute("mensagem", "Ninja not found");
            return "listNinjas";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteNinjaById(@PathVariable Long id) {
        ninjaService.deleteNinjaById(id);
        return "redirect:/ninjas/ui/list";
    }

    @GetMapping("/add")
    public String showNinjaAddFormulary(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "addNinja";
    }

    @PostMapping("/save")
    public String saveNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        ninjaService.createNinja(ninja);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja successfully registered!");
        return "redirect:/ninjas/ui/listar";
    }
}
