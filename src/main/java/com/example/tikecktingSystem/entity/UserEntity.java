package com.example.tikecktingSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(exclude = "vehicles")
@ToString(exclude = "vehicles")
public class UserEntity {
    @Id
    private String userNic;
    private String userName;
    private String address;
    private String contact;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<VehicleEntity> vehicles;
}
