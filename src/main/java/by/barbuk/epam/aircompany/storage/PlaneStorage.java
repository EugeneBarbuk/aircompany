package by.barbuk.epam.aircompany.storage;

import by.barbuk.epam.aircompany.models.PlaneType;
import by.barbuk.epam.aircompany.planes.MilitaryPlane;
import by.barbuk.epam.aircompany.planes.PassengerPlane;
import by.barbuk.epam.aircompany.planes.Plane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class PlaneStorage implements Storage<Plane> {

    private static final Logger LOGGER = LogManager.getLogger();
    private List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, PlaneType.MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, PlaneType.MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, PlaneType.MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, PlaneType.MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, PlaneType.MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, PlaneType.MilitaryType.TRANSPORT)
    );
    private PlaneStorage() {

    }

    private static class SingletonHolder {
        private static final PlaneStorage INSTANCE = new PlaneStorage();
    }

    public static PlaneStorage getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public List<Plane> addPlane(Plane plane) {
        planes.add(plane);
        LOGGER.info(planes);
        return planes;

    }
    public List<Plane> getAllPlanesFromList (){
        return planes;
    }
}