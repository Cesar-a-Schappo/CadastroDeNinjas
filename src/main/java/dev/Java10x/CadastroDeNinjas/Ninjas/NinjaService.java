package dev.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

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
    public List<NinjaDTO> listAllNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .toList();
    }

    // Listar ninjas por ID
    public NinjaDTO listNinjaById(Long id) {
        Optional<NinjaModel> ninjaById = ninjaRepository.findById(id);
        return ninjaById.map(ninjaMapper::map).orElse(null);
    }

    // Atualizar ninja
    public NinjaDTO updateNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaToUpdate = ninjaRepository.findById(id);
        if (ninjaToUpdate.isPresent()) {
            NinjaModel updatedNinja = ninjaMapper.map(ninjaDTO);
            updatedNinja.setId(id);
            NinjaModel savedNinja = ninjaRepository.save(updatedNinja);
            return ninjaMapper.map(savedNinja);
        }
        return null;
    }

    // Deletar ninja - Tem que ser um metodo void
    public void deleteNinjaById(Long id) {
        ninjaRepository.deleteById(id);
    }

}
