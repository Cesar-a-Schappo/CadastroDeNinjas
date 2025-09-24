package dev.Java10x.CadastroDeNinjas.Missions;

import dev.Java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    // Listar missoes por id
    public MissionsModel listMissionById(Long id) {
        Optional<MissionsModel> missionById = missionsRepository.findById(id);
        return missionById.orElse(null);
    }

    // Atualizar missoes
    public MissionsModel updateMission(Long id, MissionsModel updatedMission) {
        if (missionsRepository.existsById(id)) {
            updatedMission.setId(id);
            return missionsRepository.save(updatedMission);
        }
        return null;
    }

    // Deletar missao
    public void deleteMissionById(Long id) {
        missionsRepository.deleteById(id);
    }

}
