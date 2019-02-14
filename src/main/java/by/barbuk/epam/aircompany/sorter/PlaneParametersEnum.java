package by.barbuk.epam.aircompany.sorter;

public enum PlaneParametersEnum {
    SPEED(true),FLIGHT_DISTANCE(true),LOAD_CAPACITY(true), MODEL(true);
    private boolean ascend;
    private PlaneParametersEnum(boolean ascend) {
        this.ascend = ascend;
    }
    public void setAscend(boolean ascend) {
        this.ascend = ascend;
    }
    public boolean getAscend() {
        return ascend;
    }
}
