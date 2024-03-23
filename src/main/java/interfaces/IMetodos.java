/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package interfaces;

import java.util.ArrayList;

public interface IMetodos<T> {
    Integer create(T object);

    void remove(T object);

    void update(T object);

    T get(int id);

    ArrayList<T> getAll();

}
