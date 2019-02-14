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
 * To sort descending set SPEED.setAscend(false)
 */
public class SortPlaneByMaxSpeedTest {
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
    public void testSortPlaneByMaxSpeedAscending() {
        List<Integer> actual = new ArrayList<>();
        List<Integer> expected = Arrays.asList(277, 900, 1050);
        PlaneParametersEnum.SPEED.setAscend(true);
        planeList.sort(new PlaneByParametersComparator(PlaneParametersEnum.SPEED));
        planeList.forEach(plane -> actual.add(plane.getMaxPlaneSpeed()));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSortPlaneByMaxLoadCapacityDescending() {
        List<Integer> actual = new ArrayList<>();
        List<Integer> expected = Arrays.asList(1050, 900, 277);
        PlaneParametersEnum.SPEED.setAscend(false);
        planeList.sort(new PlaneByParametersComparator(PlaneParametersEnum.SPEED));
        planeList.forEach(plane -> actual.add(plane.getMaxPlaneSpeed()));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSortPlaneByMaxLoadCapacityNegative() {
        List<Integer> actual = new ArrayList<>();
        List<Integer> expected = Arrays.asList(900, 277, 1050);
        planeList.sort(new PlaneByParametersComparator(PlaneParametersEnum.SPEED));
        planeList.forEach(plane -> actual.add(plane.getMaxPlaneSpeed()));
        Assert.assertNotEquals(actual, expected);
    }
}
