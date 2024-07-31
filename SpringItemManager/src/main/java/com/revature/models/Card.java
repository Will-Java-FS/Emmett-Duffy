package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Card

{

    private int number;
    private String Name;
    private String Type;
    private String Condition;

}
