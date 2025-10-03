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
@ToString(exclude = "missions")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(unique = true, name = "email")
    private String email;

    @Column(name = "img_url")
    private String imgURL;

    @Column(name = "age")
    private int age;

    @Column(name = "rank")
    private String rank;

    // @ManyToOne: um ninja tem uma unica missao
    @ManyToOne
    @JoinColumn(name = "missions_id") // Foreing Key ou chave estrangeira
    private MissionsModel missions;

}
