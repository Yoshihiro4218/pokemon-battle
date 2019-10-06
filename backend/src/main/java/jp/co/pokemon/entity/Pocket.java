package jp.co.pokemon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pocket {
    private int id;
    private int trainerId;
    private int position;
    private int pkId;
}
