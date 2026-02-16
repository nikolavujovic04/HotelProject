/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.time.LocalDate;

/**
 *
 * @author Nikola
 */
public class RecepcionarTerminDezurstva {
    private LocalDate datumDezurstva;
    private Recepcionist recepcionarId;
    private TerminDezustva terminDezurstvaId;

    public RecepcionarTerminDezurstva() {
    }

    public RecepcionarTerminDezurstva(LocalDate datumDezurstva, Recepcionist recepcionarId, TerminDezustva terminDezurstvaId) {
        this.datumDezurstva = datumDezurstva;
        this.recepcionarId = recepcionarId;
        this.terminDezurstvaId = terminDezurstvaId;
    }

    public LocalDate getDatumDezurstva() {
        return datumDezurstva;
    }

    public void setDatumDezurstva(LocalDate datumDezurstva) {
        this.datumDezurstva = datumDezurstva;
    }

    public Recepcionist getRecepcionarId() {
        return recepcionarId;
    }

    public void setRecepcionarId(Recepcionist recepcionarId) {
        this.recepcionarId = recepcionarId;
    }

    public TerminDezustva getTerminDezurstvaId() {
        return terminDezurstvaId;
    }

    public void setTerminDezurstvaId(TerminDezustva terminDezurstvaId) {
        this.terminDezurstvaId = terminDezurstvaId;
    }
}
