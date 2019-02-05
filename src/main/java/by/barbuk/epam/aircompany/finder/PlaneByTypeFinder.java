package by.barbuk.epam.aircompany.finder;

import by.barbuk.epam.aircompany.models.PlaneType;
import by.barbuk.epam.aircompany.planes.ExperimentalPlane;
import by.barbuk.epam.aircompany.planes.MilitaryPlane;
import by.barbuk.epam.aircompany.planes.PassengerPlane;
import by.barbuk.epam.aircompany.planes.Plane;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PlaneByTypeFinder {

    public List<PassengerPlane> findPassengerPlane(Collection<? extends Plane> planesList) {
        return (List<PassengerPlane>) planesList.stream().filter(plane -> plane instanceof PassengerPlane).collect(Collectors.toList());
    }

    public List<ExperimentalPlane> findExperimentalPlane(Collection<? extends Plane> planesList) {
        return (List<ExperimentalPlane>) planesList.stream().filter(plane -> plane instanceof ExperimentalPlane).collect(Collectors.toList());
    }

    public List<MilitaryPlane> findMilitaryPlanes(Collection<? extends Plane> planesList) {

        return (List<MilitaryPlane>) planesList.stream().filter(plane -> plane instanceof MilitaryPlane).collect(Collectors.toList());
    }

    public List<MilitaryPlane> findTransportMilitaryPlanes(Collection<MilitaryPlane> militaryPlaneList) {
        return militaryPlaneList.stream().filter(militaryPlane -> militaryPlane.getPlaneType().equals(PlaneType.MilitaryType.TRANSPORT)).collect(Collectors.toList());
    }

    public List<MilitaryPlane> findBomberMilitaryPlanes(Collection<MilitaryPlane> militaryPlaneList) {
        return militaryPlaneList.stream().filter(militaryPlane -> militaryPlane.getPlaneType().equals(PlaneType.MilitaryType.BOMBER)).collect(Collectors.toList());
    }

}