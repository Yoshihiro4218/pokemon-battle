package jp.co.pokemon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Trainer {
    private int id;
    private int userId;
    private String trainerName;
    private int winningCount;
    private int losingCount;
    private boolean battleFlg;
}
