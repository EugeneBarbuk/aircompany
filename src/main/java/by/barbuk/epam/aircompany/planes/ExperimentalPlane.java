package by.barbuk.epam.aircompany.planes;

import by.barbuk.epam.aircompany.models.PlaneType;

import java.util.Objects;

public class ExperimentalPlane extends Plane {

    private PlaneType.ExperimentalType planeType;
    private PlaneType.SecurityType planeSecurityType;

    public ExperimentalPlane(String planeModel, int maxPlaneSpeed, int maxPlaneFlightDistance, int maxPlaneLoadCapacity, PlaneType.ExperimentalType planeType, PlaneType.SecurityType planeSecurityType) {
        super(planeModel, maxPlaneSpeed, maxPlaneFlightDistance, maxPlaneLoadCapacity);
        this.planeType = planeType;
        this.planeSecurityType = planeSecurityType;
    }

    public PlaneType.SecurityType getPlaneSecurityType() {
        return planeSecurityType;
    }

    public void setPlaneSecurityType(PlaneType.SecurityType planeSecurityType) {
        this.planeSecurityType = planeSecurityType;
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
        ExperimentalPlane that = (ExperimentalPlane) o;
        return planeType == that.planeType &&
                getPlaneSecurityType() == that.getPlaneSecurityType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), planeType, getPlaneSecurityType());
    }

    @Override
    public String toString() {
        return "ExperimentalPlane{" +
                "model='" + getPlaneModel() + '\'' +
                '}';
    }
}
