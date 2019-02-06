package by.barbuk.epam.aircompany.planes;

import java.util.Objects;

public class Plane {
    private String planeModel;
    private int maxPlaneSpeed;
    private int maxPlaneFlightDistance;
    private int maxPlaneLoadCapacity;

    public Plane(String planeModel, int maxPlaneSpeed, int maxPlaneFlightDistance, int maxPlaneLoadCapacity) {
        this.planeModel = planeModel;
        this.maxPlaneSpeed = maxPlaneSpeed;
        this.maxPlaneFlightDistance = maxPlaneFlightDistance;
        this.maxPlaneLoadCapacity = maxPlaneLoadCapacity;
    }


    public void setPlaneModel(String planeModel) {

        this.planeModel = planeModel;
    }

    public void setMaxPlaneSpeed(int maxPlaneSpeed) {
        this.maxPlaneSpeed = maxPlaneSpeed;
    }

    public void setMaxPlaneFlightDistance(int maxPlaneFlightDistance) {
        this.maxPlaneFlightDistance = maxPlaneFlightDistance;
    }

    public void setMaxPlaneLoadCapacity(int maxPlaneLoadCapacity) {
        this.maxPlaneLoadCapacity = maxPlaneLoadCapacity;
    }

    public String getPlaneModel() {
        return planeModel;
    }

    public int getMaxPlaneSpeed() {
        return maxPlaneSpeed;
    }

    public int getMaxPlaneFlightDistance() {
        return maxPlaneFlightDistance;
    }

    public int getMaxPlaneLoadCapacity() {
        return this.maxPlaneLoadCapacity;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "planeModel='" + planeModel + '\'' +
                ", maxPlaneSpeed=" + maxPlaneSpeed +
                ", maxPlaneFlightDistance=" + maxPlaneFlightDistance +
                ", maxPlaneLoadCapacity=" + maxPlaneLoadCapacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((this.getClass() != o.getClass())) {
            return false;
        }
        Plane that = (Plane) o;
        return getMaxPlaneSpeed() == that.getMaxPlaneSpeed() &&
                getMaxPlaneFlightDistance() == that.getMaxPlaneFlightDistance() &&
                getMaxPlaneLoadCapacity() == that.getMaxPlaneLoadCapacity() &&
                Objects.equals(getPlaneModel(), that.getPlaneModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlaneModel(), getMaxPlaneSpeed(), getMaxPlaneFlightDistance(), getMaxPlaneLoadCapacity());
    }
}
