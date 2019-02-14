package test.by.barbuk.epam.aircompany.finder;

import by.barbuk.epam.aircompany.finder.PlaneByTypeFinder;
import by.barbuk.epam.aircompany.models.PlaneTypeEnum;
import by.barbuk.epam.aircompany.planes.MilitaryPlane;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FindBomberMilitaryPlaneTest {
    private PlaneByTypeFinder planeByTypeFinder = new PlaneByTypeFinder();
    private List<MilitaryPlane> planeList = new ArrayList<>();

    @BeforeClass
    public void fillPlaneList() {
        planeList.add(new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, PlaneTypeEnum.MilitaryType.BOMBER));
        planeList.add(new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, PlaneTypeEnum.MilitaryType.TRANSPORT));
    }


    @AfterClass
    public void clear() {
        planeList = null;
    }

    @Test
    public void testBomberMilitaryPlane(){
        String expected = "B-1B Lancer";
        String actual = planeByTypeFinder.findBomberMilitaryPlanes(planeList).get(0).getPlaneModel();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindBomberMilitaryNegative() {
        String expected = "C-130 Hercules";
        String actual = planeByTypeFinder.findBomberMilitaryPlanes(planeList).get(0).getPlaneModel();
        Assert.assertNotEquals(actual, expected);
    }
}
