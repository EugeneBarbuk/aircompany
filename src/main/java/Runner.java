import by.barbuk.epam.aircompany.buildings.Airport;
import by.barbuk.epam.aircompany.models.PlaneType;
import by.barbuk.epam.aircompany.planes.Plane;
import by.barbuk.epam.aircompany.planes.MilitaryPlane;
import by.barbuk.epam.aircompany.planes.PassengerPlane;
import by.barbuk.epam.aircompany.finder.PlaneByTypeFinder;




import by.barbuk.epam.aircompany.storage.PlaneStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

    private static final  Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {

        PlaneByTypeFinder planeByTypeFinder = new PlaneByTypeFinder();
        LOGGER.info("------------------------------------------");
        LOGGER.info(planeByTypeFinder.findBomberMilitaryPlanes(planeByTypeFinder.findMilitaryPlanes(PlaneStorage.getInstance().getAllPlanesFromList())));

    }
}
