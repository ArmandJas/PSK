package org.example.PSK.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;

@Entity
public class example {
    @Basic
    private String basic;

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }
}
