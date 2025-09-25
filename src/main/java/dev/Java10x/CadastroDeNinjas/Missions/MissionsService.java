package dev.Java10x.CadastroDeNinjas.Missions;

import dev.Java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissionsService {

    private MissionsRepository missionsRepository;
    private MissionsMapper missionsMapper;

    public MissionsService(MissionsRepository missionsRepository, MissionsMapper missionsMapper) {
        this.missionsRepository = missionsRepository;
        this.missionsMapper = missionsMapper;
    }

    // Criar nova missao
    public MissionsDTO createMission(MissionsDTO missionsDTO) {
        MissionsModel mission = missionsMapper.map(missionsDTO);
        mission = missionsRepository.save(mission);
        return missionsMapper.map(mission);
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
