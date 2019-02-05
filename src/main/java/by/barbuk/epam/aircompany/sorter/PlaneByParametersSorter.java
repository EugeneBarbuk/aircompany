package by.barbuk.epam.aircompany.sorter;

import by.barbuk.epam.aircompany.planes.Plane;
import java.util.List;


public class PlaneByParametersSorter {

    public List<Plane> sortPlaneByMaxSpeed(List<? extends Plane> planesList) {

        planesList.sort((o1, o2) -> o2.getMaxPlaneSpeed() - o1.getMaxPlaneSpeed());

        return (List<Plane>) planesList;
    }

    public List<Plane> sortPlaneByMaxLoadCapacity(List<? extends Plane> planesList) {
        planesList.sort((o1, o2) -> o2.getMaxPlaneLoadCapacity() - o1.getMaxPlaneLoadCapacity());

        return (List<Plane>) planesList;
    }
}
