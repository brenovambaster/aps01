/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package helpers;

import entidades.campus.Campus;

public class CampusHelper {

    public static void validateCampus(Campus campus) throws IllegalArgumentException {
        if (campus == null)
            throw new IllegalArgumentException("Campus não pode ser null");
    }
}
