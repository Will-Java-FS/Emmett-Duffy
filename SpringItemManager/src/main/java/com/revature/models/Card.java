package com.revature.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Data
public class Card

{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer number;

    @Column(unique=true)
    private String name;

    @Column
    private String type;

    @Column
    private Integer health;

    public Card(){

    }

    public Card(String name, String type, Integer health) {
        this.name = name;
        this.type = type;
        this.health = health;
    }

    public Card(Integer number, String name, String type, Integer health) {
        this.number = number;
        this.name = name;
        this.type = type;
        this.health = health;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (number == null) {
            if (other.number != null)
                return false;
        } else if (!number.equals(other.number))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        if (health == null) {
            if (other.health != null)
                return false;
        } else if (!health.equals(other.health))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Card{" +
                "Card Number =" + number +
                ", Card Name =" + name +
                ", Card Type ='" + type + '\'' +
                ", Card HP =" + health +
                '}';
    }

}
