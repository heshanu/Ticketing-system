package com.example.tikecktingSystem.dto;

import com.example.tikecktingSystem.entity.VehicleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @NotNull
    private String userName;

    @NotNull
    private String address;

    @NotNull
    private String contact;
    private Set<VehicleEntity> vehicles;
}
