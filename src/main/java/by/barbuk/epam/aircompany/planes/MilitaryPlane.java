package by.barbuk.epam.aircompany.planes;

import by.barbuk.epam.aircompany.models.PlaneTypeEnum;

import java.util.Objects;

public class MilitaryPlane extends Plane {
    private PlaneTypeEnum.MilitaryType planeType;

    public MilitaryPlane(String planeModel, int maxPlaneSpeed, int maxPlaneFlightDistance, int maxPlaneLoadCapacity, PlaneTypeEnum.MilitaryType planeType) {
        super(planeModel, maxPlaneSpeed, maxPlaneFlightDistance, maxPlaneLoadCapacity);
        this.planeType = planeType;
    }

    public PlaneTypeEnum.MilitaryType getPlaneType() {
        return planeType;
    }

    public void setPlaneType(PlaneTypeEnum.MilitaryType planeType) {
        this.planeType = planeType;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", planeType=" + planeType +
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
        MilitaryPlane that = (MilitaryPlane) o;
        return planeType == that.planeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), planeType);
    }
}
