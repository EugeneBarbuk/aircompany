package by.barbuk.epam.aircompany.sorter;

import by.barbuk.epam.aircompany.planes.Plane;

import java.util.List;


public class PlaneByParametersSorter {

    public List<Plane> sortPlaneByMaxSpeed(List<? extends Plane> planesList) {

        planesList.sort((o1, o2) -> o1.getMaxPlaneSpeed() - o2.getMaxPlaneSpeed());

        return (List<Plane>) planesList;
    }

    public List<Plane> sortPlaneByMaxLoadCapacity(List<? extends Plane> planesList) {
        planesList.sort((o1, o2) -> o1.getMaxPlaneLoadCapacity() - o2.getMaxPlaneLoadCapacity());

        return (List<Plane>) planesList;
    }
}
