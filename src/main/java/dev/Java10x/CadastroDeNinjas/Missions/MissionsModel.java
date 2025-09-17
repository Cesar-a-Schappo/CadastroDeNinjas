package dev.Java10x.CadastroDeNinjas.Missions;

import dev.Java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_mission")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private char rank;

    // @OneToMany: uma missao pode ter varios ninjas
    @OneToMany(mappedBy = "missions")
    private List<NinjaModel> ninja;

}
