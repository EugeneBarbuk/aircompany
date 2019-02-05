package by.barbuk.epam.aircompany.planes;

import java.util.Objects;

public class PassengerPlane extends Plane {

    private int passengersPlaneCapacity;

    public PassengerPlane(String planeModel, int maxPlaneSpeed, int maxPlaneFlightDistance, int maxPlaneLoadCapacity, int passengersPlaneCapacity) {
        super(planeModel, maxPlaneSpeed, maxPlaneFlightDistance, maxPlaneLoadCapacity);
        this.passengersPlaneCapacity = passengersPlaneCapacity;
    }


    public int getPassengersPlaneCapacity() {
        return passengersPlaneCapacity;
    }

    public void setPassengersPlaneCapacity(int passengersPlaneCapacity) {
        this.passengersPlaneCapacity = passengersPlaneCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", passengersPlaneCapacity=" + passengersPlaneCapacity +
                        '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((this.getClass() != o.getClass())) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        PassengerPlane plane = (PassengerPlane) o;
        return passengersPlaneCapacity == plane.passengersPlaneCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersPlaneCapacity);
    }
}
