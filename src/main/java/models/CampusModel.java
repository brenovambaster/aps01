package models;

import entidades.campus.Campus;

import java.util.ArrayList;

public class CampusModel {
    private static ArrayList<Campus> campusList = new ArrayList<>();
    private static Integer id = 0;

    public static Integer create(Campus campus) {
        campus.setId(id);
        campusList.add(campus);
        return id++;
    }

    public static void remove(Campus campus) {
        campusList.removeIf(c -> c.getId().equals(campus.getId()));
    }

    public static void update(Campus campus) {
        for (int i = 0; i < campusList.size(); i++) {
            if (campusList.get(i).getId().equals(campus.getId())) {
                campusList.set(i, campus);
                break;
            }
        }
    }

    public static Campus get(int id) {
        return campusList.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public static ArrayList<Campus> getAll() {
        return campusList;
    }
}