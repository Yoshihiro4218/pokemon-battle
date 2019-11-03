package jp.co.pokemon.util;

import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

public class With {
    public static <T> Consumer<T> index(int start, ObjIntConsumer<T> consumer) {
        int counter[] = { start };
        return obj -> consumer.accept(obj, counter[0]++);
    }
}