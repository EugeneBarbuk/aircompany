package test.by.barbuk.epam.aircompany.sorter;

import by.barbuk.epam.aircompany.models.PlaneTypeEnum;
import by.barbuk.epam.aircompany.planes.ExperimentalPlane;
import by.barbuk.epam.aircompany.planes.MilitaryPlane;
import by.barbuk.epam.aircompany.planes.PassengerPlane;
import by.barbuk.epam.aircompany.planes.Plane;
import by.barbuk.epam.aircompany.sorter.PlaneByParametersComparator;
import by.barbuk.epam.aircompany.sorter.PlaneParametersEnum;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Checks the sorting by parameter.
 * Provides sorting ascending and descending
 * To sort descending set FLIGHT_DISTANCE.setAscend(false)
 */
public class SortPlaneByMaxFlightDistanceTest {

    private List<Plane> planeList = new ArrayList<>();

    @BeforeClass
    public void fillPlaneList() {
        planeList.add(new PassengerPlane("Boeing-737", 900, 12000, 60500, 164));
        planeList.add(new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, PlaneTypeEnum.MilitaryType.BOMBER));
        planeList.add(new ExperimentalPlane("Bell X-14", 277, 482, 500, PlaneTypeEnum.ExperimentalType.HIGH_ALTITUDE, PlaneTypeEnum.SecurityType.SECRET));
    }

    @AfterClass
    public void clear() {
        planeList = null;
    }

    @Test
    public void testSortPlaneByMaxFlightDistanceAscending() {
        List<Integer> actual = new ArrayList<>();
        List<Integer> expected = Arrays.asList(482, 12000, 21000);
        PlaneParametersEnum.FLIGHT_DISTANCE.setAscend(true);
        planeList.sort(new PlaneByParametersComparator(PlaneParametersEnum.FLIGHT_DISTANCE));
        planeList.forEach(plane -> actual.add(plane.getMaxPlaneFlightDistance()));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSortPlaneByMaxFlightDistanceDescending() {
        List<Integer> actual = new ArrayList<>();
        List<Integer> expected = Arrays.asList(21000, 12000, 482);
        PlaneParametersEnum.FLIGHT_DISTANCE.setAscend(false);
        planeList.sort(new PlaneByParametersComparator(PlaneParametersEnum.FLIGHT_DISTANCE));
        planeList.forEach(plane -> actual.add(plane.getMaxPlaneFlightDistance()));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSortPlaneByMaxFlightDistanceNegative() {
        List<Integer> actual = new ArrayList<>();
        List<Integer> expected = Arrays.asList(12000, 21000, 482);
        planeList.sort(new PlaneByParametersComparator(PlaneParametersEnum.FLIGHT_DISTANCE));
        planeList.forEach(plane -> actual.add(plane.getMaxPlaneFlightDistance()));
        Assert.assertNotEquals(actual, expected);
    }
}

