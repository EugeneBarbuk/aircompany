package by.barbuk.epam.aircompany.buildings;

import by.barbuk.epam.aircompany.models.PlaneType;
import by.barbuk.epam.aircompany.planes.Plane;
import by.barbuk.epam.aircompany.planes.ExperimentalPlane;
import by.barbuk.epam.aircompany.planes.MilitaryPlane;
import by.barbuk.epam.aircompany.planes.PassengerPlane;

import java.util.*;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {

    private List<? extends Plane> planesList;

    public List<PassengerPlane> findPassengerPlane() {
        List<PassengerPlane> passengerPlaneArrayList = new ArrayList<>();
        for (Plane plane : planesList) {
            if (plane instanceof PassengerPlane) {
                passengerPlaneArrayList.add((PassengerPlane) plane);
            }
        }
        return passengerPlaneArrayList;
    }

    public List<MilitaryPlane> findMilitaryPlanes() {
        List<MilitaryPlane> militaryPlaneArrayList = new ArrayList<>();
        for (Plane plane : planesList) {
            if (plane instanceof MilitaryPlane) {
                militaryPlaneArrayList.add((MilitaryPlane) plane);
            }
         }
        return militaryPlaneArrayList;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = findPassengerPlane();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (int i = 0; i < passengerPlanes.size(); i++) {
            if (passengerPlanes.get(i).getPassengersPlaneCapacity() > planeWithMaxCapacity.getPassengersPlaneCapacity()) {
                planeWithMaxCapacity = passengerPlanes.get(i);
            }
        }


        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = findMilitaryPlanes();
        for (int i = 0; i < militaryPlanes.size(); i++) {
            MilitaryPlane plane = militaryPlanes.get(i);
            if (plane.getPlaneType() == PlaneType.MilitaryType.TRANSPORT) {
                transportMilitaryPlanes.add(plane);
            }
        }
        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = findMilitaryPlanes();
        for (int i = 0; i < militaryPlanes.size(); i++) {
            MilitaryPlane plane = militaryPlanes.get(i);
            if (plane.getPlaneType() == PlaneType.MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(plane);
            }
        }
        return bomberMilitaryPlanes;

    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planesList) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public Airport sortByMaxDistance() {
        Collections.sort(planesList, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxPlaneFlightDistance() - o2.getMaxPlaneFlightDistance();
            }
        });
        return this;
    }





    private void print(Collection<? extends Plane> collection) {
        Iterator<? extends Plane> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Plane plane = iterator.next();
            System.out.println(plane);
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "by.barbuk.epam.aircompany.buildings.planesList=" + planesList.toString() +
                '}';
    }

    //Constructor
    public Airport(List<? extends Plane> planesList) {
        this.planesList = planesList;
    }

}
