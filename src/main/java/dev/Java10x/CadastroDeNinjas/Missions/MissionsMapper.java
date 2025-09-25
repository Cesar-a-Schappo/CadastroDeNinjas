package dev.Java10x.CadastroDeNinjas.Missions;

import org.springframework.stereotype.Component;

@Component
public class MissionsMapper {

    public MissionsModel map(MissionsDTO missionsDTO) {
        MissionsModel missionsModel = new MissionsModel();
        missionsModel.setId(missionsDTO.getId());
        missionsModel.setName(missionsDTO.getName());
        missionsModel.setRank(missionsDTO.getRank());
        missionsModel.setNinja(missionsDTO.getNinja());

        return missionsModel;
    }

    public MissionsDTO map(MissionsModel missionsModel) {
        MissionsDTO missionsDTO = new MissionsDTO();
        missionsDTO.setId(missionsModel.getId());
        missionsDTO.setName(missionsModel.getName());
        missionsDTO.setRank(missionsModel.getRank());
        missionsDTO.setNinja(missionsModel.getNinja());

        return missionsDTO;
    }

}
