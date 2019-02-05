package test.by.barbuk.epam.aircompany.sorter;

import by.barbuk.epam.aircompany.models.PlaneType;
import by.barbuk.epam.aircompany.planes.ExperimentalPlane;
import by.barbuk.epam.aircompany.planes.MilitaryPlane;
import by.barbuk.epam.aircompany.planes.PassengerPlane;
import by.barbuk.epam.aircompany.planes.Plane;
import by.barbuk.epam.aircompany.sorter.PlaneByParametersSorter;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortPlaneByMaxLoadCapacityTest {
    private PlaneByParametersSorter planeByParametersSorter = new PlaneByParametersSorter();
    private List<Plane> planeList = new ArrayList<>();

    @BeforeClass
    public void fillPlaneList() {
        planeList.add(new PassengerPlane("Boeing-737", 900, 12000, 60500, 164));
        planeList.add(new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, PlaneType.MilitaryType.BOMBER));
        planeList.add(new ExperimentalPlane("Bell X-14", 277, 482, 500, PlaneType.ExperimentalType.HIGH_ALTITUDE, PlaneType.SecurityType.SECRET));
    }


    @AfterClass
    public void clear() {
        planeList = null;
    }

    @Test
    public void testSortPlaneByMaxLoadCapacity() {
        List<String> actual = new ArrayList<>();
        List<String> expected = Arrays.asList("B-1B Lancer", "Boeing-737", "Bell X-14");
        planeByParametersSorter.sortPlaneByMaxLoadCapacity(planeList).forEach(plane -> actual.add(plane.getPlaneModel()));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSortPlaneByMaxLoadCapacityNegative() {
        List<String> actual = new ArrayList<>();
        List<String> expected = Arrays.asList("Boeing-737", "B-1B Lancer", "Bell X-14");
        planeByParametersSorter.sortPlaneByMaxLoadCapacity(planeList).forEach(plane -> actual.add(plane.getPlaneModel()));
        Assert.assertNotEquals(actual, expected);
    }
}
