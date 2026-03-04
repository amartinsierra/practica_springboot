package com.igae.init.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDto {
    private Integer idVuelo;
    private String nombre;
    private String dni;
    private int personas;
}