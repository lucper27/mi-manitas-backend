package com.lucasoft.mimanitas.application.dto;

import java.io.Serializable;

public class ZoneDTO implements Serializable {

    private Long id;
    private String name;
    public ZoneDTO() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
