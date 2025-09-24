package dev.Java10x.CadastroDeNinjas.Missions;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionsService {

    private MissionsRepository missionsRepository;

    public MissionsService(MissionsRepository missionsRepository) {
        this.missionsRepository = missionsRepository;
    }

    // Criar nova missao
    public MissionsModel createMission(MissionsModel missions) {
        return missionsRepository.save(missions);
    }

    // Listar todas as missoes
    public List<MissionsModel> listMissions() {
        return missionsRepository.findAll();
    }

    // Deletar missao
    public void deleteMissionById(Long id) {
        missionsRepository.deleteById(id);
    }

}
