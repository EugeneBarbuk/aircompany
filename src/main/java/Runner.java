import by.barbuk.epam.aircompany.finder.PlaneByTypeFinder;


import by.barbuk.epam.aircompany.sorter.PlaneByParametersSorter;
import by.barbuk.epam.aircompany.storage.PlaneStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

    private static final  Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {

        PlaneByTypeFinder planeByTypeFinder = new PlaneByTypeFinder();
        PlaneByParametersSorter planeByParametersSorter = new PlaneByParametersSorter();
        LOGGER.info("------------------------------------------");
        LOGGER.info(planeByTypeFinder.findBomberMilitaryPlanes(planeByTypeFinder.findMilitaryPlanes(PlaneStorage.getInstance().getAllPlanesFromList())));
        LOGGER.info(planeByParametersSorter.sortPlaneByMaxSpeed(PlaneStorage.getInstance().getAllPlanesFromList()));
    }
}
