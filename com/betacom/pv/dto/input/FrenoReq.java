package com.betacom.pv.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FrenoReq {
    @NotNull(groups = ValidationGroups.Create.class, message = "bici.no.tipoFreno")
    @NotBlank(groups = ValidationGroups.Create.class, message = "bici.no.tipoFreno")
    private String descrizione;
}
