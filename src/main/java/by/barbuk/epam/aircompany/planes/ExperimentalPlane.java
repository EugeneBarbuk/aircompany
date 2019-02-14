package by.barbuk.epam.aircompany.planes;

import by.barbuk.epam.aircompany.models.PlaneTypeEnum;

import java.util.Objects;

public class ExperimentalPlane extends Plane {

    private PlaneTypeEnum.ExperimentalType planeType;
    private PlaneTypeEnum.SecurityType planeSecurityType;

    public ExperimentalPlane(String planeModel, int maxPlaneSpeed, int maxPlaneFlightDistance, int maxPlaneLoadCapacity, PlaneTypeEnum.ExperimentalType planeType, PlaneTypeEnum.SecurityType planeSecurityType) {
        super(planeModel, maxPlaneSpeed, maxPlaneFlightDistance, maxPlaneLoadCapacity);
        this.planeType = planeType;
        this.planeSecurityType = planeSecurityType;
    }

    public PlaneTypeEnum.SecurityType getPlaneSecurityType() {
        return planeSecurityType;
    }

    public void setPlaneSecurityType(PlaneTypeEnum.SecurityType planeSecurityType) {
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
                "planeType=" + planeType +
                ", planeSecurityType=" + planeSecurityType +
                "} " + super.toString();
    }
}
