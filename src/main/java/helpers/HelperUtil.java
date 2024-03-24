/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package helpers;

import javax.lang.model.type.NullType;

public class HelperUtil<T> {

    public static <T> void validateObject(T object) throws IllegalArgumentException {
        if (object == null)
            throw new IllegalArgumentException("O objeto  não pode ser null");
    }
}