package dev.Java10x.CadastroDeNinjas.Missions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.Java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "tb_mission")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MissionsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "rank")
    private char rank;

    // @OneToMany: uma missao pode ter varios ninjas
    @OneToMany(mappedBy = "missions")
    @JsonIgnore
    private List<NinjaModel> ninja;

}
