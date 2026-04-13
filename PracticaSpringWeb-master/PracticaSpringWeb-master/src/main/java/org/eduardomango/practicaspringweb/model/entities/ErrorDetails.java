package org.eduardomango.practicaspringweb.model.entities;

import java.time.LocalDate;

public class ErrorDetails {
    private LocalDate timeStamp;
    private String mensaje;
    private String detalles;

    public ErrorDetails(String mensaje, String detalles) {
        this.timeStamp = LocalDate.now();
        this.mensaje = mensaje;
        this.detalles = detalles;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getDetalles() {
        return detalles;
    }

}
