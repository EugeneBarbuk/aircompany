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

public class SortPlaneByModelTest {
    private List<Plane> planeList = new ArrayList<>();

    @BeforeClass
    public void fillPlaneList() {
        planeList.add(new PassengerPlane("Boeing-737", 900, 12000, 60500, 164));
        planeList.add(new MilitaryPlane("Lancer", 1050, 21000, 80000, PlaneTypeEnum.MilitaryType.BOMBER));
        planeList.add(new ExperimentalPlane("Bell X-14", 277, 482, 500, PlaneTypeEnum.ExperimentalType.HIGH_ALTITUDE, PlaneTypeEnum.SecurityType.SECRET));
    }


    @AfterClass
    public void clear() {
        planeList = null;
    }

    @Test
    public void testSortPlaneByModelAscending() {
        List<String> actual = new ArrayList<>();
        List<String> expected = Arrays.asList("Bell X-14", "Boeing-737", "Lancer");
        PlaneParametersEnum.MODEL.setAscend(true);
        planeList.sort(new PlaneByParametersComparator(PlaneParametersEnum.MODEL));
        planeList.forEach(plane -> actual.add(plane.getPlaneModel()));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSortPlaneByModelDescending() {
        List<String> actual = new ArrayList<>();
        List<String> expected = Arrays.asList("Lancer", "Boeing-737", "Bell X-14");
        PlaneParametersEnum.MODEL.setAscend(false);
        planeList.sort(new PlaneByParametersComparator(PlaneParametersEnum.MODEL));
        planeList.forEach(plane -> actual.add(plane.getPlaneModel()));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSortPlaneByModelNegative() {
        List<String> actual = new ArrayList<>();
        List<String> expected = Arrays.asList("Boeing-737", "Bell X-14", "Lancer");
        planeList.sort(new PlaneByParametersComparator(PlaneParametersEnum.MODEL));
        planeList.forEach(plane -> actual.add(plane.getPlaneModel()));
        Assert.assertNotEquals(actual, expected);
    }
}
