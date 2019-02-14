package test.by.barbuk.epam.aircompany.finder;

import by.barbuk.epam.aircompany.finder.PlaneByTypeFinder;
import by.barbuk.epam.aircompany.models.PlaneTypeEnum;
import by.barbuk.epam.aircompany.planes.ExperimentalPlane;
import by.barbuk.epam.aircompany.planes.MilitaryPlane;
import by.barbuk.epam.aircompany.planes.PassengerPlane;
import by.barbuk.epam.aircompany.planes.Plane;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class FindPassengerPlaneTest {
    private PlaneByTypeFinder planeByTypeFinder = new PlaneByTypeFinder();
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
    public void testFindPassengerPlane() {
        String expected = "Boeing-737";
        String actual = planeByTypeFinder.findPassengerPlane(planeList).get(0).getPlaneModel();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindPassengerPlaneNegative() {
        String expected = "Bell X-14";
        String actual = planeByTypeFinder.findPassengerPlane(planeList).get(0).getPlaneModel();;
        Assert.assertNotEquals(actual, expected);
    }

}
