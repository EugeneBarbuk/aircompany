package by.barbuk.epam.aircompany.sorter;

import by.barbuk.epam.aircompany.planes.Plane;

import java.util.Comparator;
import java.util.List;

public class PlaneByParametersComparator implements Comparator<Plane> {
    private PlaneParametersEnum sortingIndex;

    public PlaneByParametersComparator(PlaneParametersEnum sortingIndex) {
        setSortingIndex(sortingIndex);
    }

    public final void setSortingIndex(PlaneParametersEnum sortingIndex) {
        if (sortingIndex == null) {
            throw new IllegalArgumentException();
        }
        this.sortingIndex = sortingIndex;
    }

    public PlaneParametersEnum getSortingIndex() {
        return sortingIndex;
    }

    @Override
    public int compare(Plane o1, Plane o2) {
        switch (sortingIndex) {
            case SPEED:
                return sortingIndex.getAscend() ? o1.getMaxPlaneSpeed() - o2.getMaxPlaneSpeed() :
                        o2.getMaxPlaneSpeed() - o1.getMaxPlaneSpeed();
            case LOAD_CAPACITY:
                return sortingIndex.getAscend() ? o1.getMaxPlaneLoadCapacity() - o2.getMaxPlaneLoadCapacity() :
                        o2.getMaxPlaneLoadCapacity() - o1.getMaxPlaneLoadCapacity();
            case FLIGHT_DISTANCE:
                return sortingIndex.getAscend() ? o1.getMaxPlaneFlightDistance() - o2.getMaxPlaneFlightDistance() :
                        o2.getMaxPlaneFlightDistance()-o1.getMaxPlaneFlightDistance();
            case MODEL:
                return sortingIndex.getAscend() ? o1.getPlaneModel().compareToIgnoreCase(o2.getPlaneModel()) :
                        o2.getPlaneModel().compareToIgnoreCase(o1.getPlaneModel());
            default:
                throw new EnumConstantNotPresentException(PlaneParametersEnum.class, sortingIndex.name());
        }

    }
}