/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package models;

public interface IDAO<T> {

    void create(T t);

    T read(String id);

    void update(T t);

    void delete(T t);

}
