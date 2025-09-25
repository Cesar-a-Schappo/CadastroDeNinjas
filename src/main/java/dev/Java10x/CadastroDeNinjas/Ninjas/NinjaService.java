package dev.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // Criar novo ninja
    public NinjaDTO createNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // Listar todos os ninjas
    public List<NinjaModel> listAllNinjas() {
        return ninjaRepository.findAll();
    }

    // Listar ninjas por ID
    public NinjaModel listNinjaById(Long id) {
        Optional<NinjaModel> ninjaById = ninjaRepository.findById(id);
        return ninjaById.orElse(null);
    }

    // Atualizar ninja
    public NinjaModel updateNinja(Long id, NinjaModel updatedNinja) {
        if (ninjaRepository.existsById(id)) {
            updatedNinja.setId(id);
            return ninjaRepository.save(updatedNinja);
        }
        return null;
    }

    // Deletar ninja - Tem que ser um metodo void
    public void deleteNinjaById(Long id) {
        ninjaRepository.deleteById(id);
    }

}
