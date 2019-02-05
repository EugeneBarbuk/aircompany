package test.by.barbuk.epam.aircompany.finder;

import by.barbuk.epam.aircompany.finder.PlaneByTypeFinder;
import by.barbuk.epam.aircompany.models.PlaneType;
import by.barbuk.epam.aircompany.planes.MilitaryPlane;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FindTransportMilitaryPlanesTest {
    private PlaneByTypeFinder planeByTypeFinder = new PlaneByTypeFinder();
    private List<MilitaryPlane> planeList = new ArrayList<>();

    @BeforeClass
    public void fillPlaneList() {
        planeList.add(new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, PlaneType.MilitaryType.BOMBER));
        planeList.add(new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, PlaneType.MilitaryType.TRANSPORT));
    }


    @AfterClass
    public void clear() {
        planeList = null;
    }

    @Test
    public void testTransportMilitaryPlane() {
        String expected = "C-130 Hercules";
        String actual = planeByTypeFinder.findTransportMilitaryPlanes(planeList).get(0).getPlaneModel();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindTransportMilitaryNegative() {
        String expected = "B-1B Lancer";
        String actual = planeByTypeFinder.findTransportMilitaryPlanes(planeList).get(0).getPlaneModel();
        Assert.assertNotEquals(actual, expected);
    }
}
