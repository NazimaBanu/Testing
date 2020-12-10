package EndtoEndFramework.EndtoEndFramework;
import org.testng.annotations.DataProvider;

public class TestData {
	@DataProvider(name="InputData")
	public static Object[][] getDataInput()
	{
		Object[][] i=new Object[][]
				{
			{"#456"},{"hello"}
				};
		return i;
	}

}
