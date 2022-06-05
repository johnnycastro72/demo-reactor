package com.sofkau.demoreactor.model;

import java.time.LocalDateTime;

public class Sale {
    private Integer idSale;
    private LocalDateTime date;

    public Sale(Integer idSale, LocalDateTime date) {
        this.idSale = idSale;
        this.date = date;
    }

    public Integer getIdSale() {
        return idSale;
    }

    public void setIdSale(Integer idSale) {
        this.idSale = idSale;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "idSale=" + idSale +
                ", date=" + date +
                '}';
    }

}
