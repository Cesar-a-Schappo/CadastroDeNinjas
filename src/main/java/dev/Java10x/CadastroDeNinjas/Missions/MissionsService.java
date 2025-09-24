package dev.Java10x.CadastroDeNinjas.Missions;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionsService {

    private MissionsRepository missionsRepository;

    public MissionsService(MissionsRepository missionsRepository) {
        this.missionsRepository = missionsRepository;
    }

    // Listar todas as missoes
    public List<MissionsModel> listMissions() {
        return missionsRepository.findAll();
    }

}
