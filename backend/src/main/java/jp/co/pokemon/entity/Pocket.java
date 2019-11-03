package jp.co.pokemon.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pocket {
    private Integer id;
    private int trainerId;
    private int position;
    private int pkId;
}
