package by.barbuk.epam.aircompany.finder;

import by.barbuk.epam.aircompany.models.PlaneType;
import by.barbuk.epam.aircompany.planes.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PlaneByTypeFinder {

    public List<Plane> findPassengerPlane(Collection<? extends Plane> planesList) {
        return planesList.stream().filter(plane -> plane instanceof PassengerPlane).collect(Collectors.toList());
    }


    public List<Plane> findExperimentalPlane(Collection<? extends Plane> planesList) {
        return planesList.stream().filter(plane -> plane instanceof ExperimentalPlane).collect(Collectors.toList());
    }


    public List<Plane> findMilitaryPlanes(Collection<? extends Plane> planesList) {

        return planesList.stream().filter(plane -> plane instanceof MilitaryPlane).collect(Collectors.toList());
    }

    public List<MilitaryPlane> findTransportMilitaryPlanes(Collection<MilitaryPlane> militaryPlaneList) {
        return militaryPlaneList.stream().filter(militaryPlane -> militaryPlane.getPlaneType()==(PlaneType.MilitaryType.TRANSPORT)).collect(Collectors.toList());
    }

    public List<MilitaryPlane> findBomberMilitaryPlanes(Collection<MilitaryPlane> militaryPlaneList) {
        return militaryPlaneList.stream().filter(militaryPlane -> militaryPlane.getPlaneType()==(PlaneType.MilitaryType.BOMBER)).collect(Collectors.toList());
    }

}