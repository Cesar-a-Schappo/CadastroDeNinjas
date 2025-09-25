package dev.Java10x.CadastroDeNinjas.Missions;

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

    // Criar missao
    public MissionsDTO createMission(MissionsDTO missionsDTO) {
        MissionsModel mission = missionsMapper.map(missionsDTO);
        mission = missionsRepository.save(mission);
        return missionsMapper.map(mission);
    }

    // Listar todas as missoes
    public List<MissionsDTO> listMissions() {
        List<MissionsModel> missions = missionsRepository.findAll();
        return missions.stream()
                .map(missionsMapper::map)
                .toList();
    }

    // Listar missoes por id
    public MissionsDTO listMissionById(Long id) {
        Optional<MissionsModel> missionById = missionsRepository.findById(id);
        return missionById.map(missionsMapper::map).orElse(null);
    }

    // Atualizar missoes
    public MissionsDTO updateMission(Long id, MissionsDTO missionsDTO) {
        Optional<MissionsModel> missionToUpdate = missionsRepository.findById(id);
        if (missionToUpdate.isPresent()) {
            MissionsModel updatedMissions = missionsMapper.map(missionsDTO);
            updatedMissions.setId(id);
            MissionsModel savedMissions = missionsRepository.save(updatedMissions);
            return missionsMapper.map(savedMissions);
        }
        return null;
    }

    // Deletar missao
    public void deleteMissionById(Long id) {
        missionsRepository.deleteById(id);
    }

}
