package dev.Java10x.CadastroDeNinjas.Ninjas;

import dev.Java10x.CadastroDeNinjas.Missions.MissionsModel;
import jakarta.persistence.*;
import lombok.*;

// Entity transforma uma classe em uma entidade BD
// JPA = Java Persistence API
@Entity
@Table(name = "tb_register")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int age;

    // @ManyToOne: um ninja tem uma unica missao
    @ManyToOne
    @JoinColumn(name = "missions_id") // Foreing Key ou chave estrangeira
    private MissionsModel missions;

}
