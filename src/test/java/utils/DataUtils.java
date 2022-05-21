package utils;

import org.testng.annotations.DataProvider;

public class DataUtils {
	@DataProvider(parallel=true)
	public String[][] getData() {
		String[][] excelData = ReadExcel.getExcelData();
		/*String[][] data = new String[3][2];
		data[0][0] = "sathikdme@gmail.com";
		data[0][1] = "123456";

		data[1][0] = "asbc@gamil.com";
		data[1][1] = "465488";
		
		data[2][0] = "pqrs@gamil.com";
		data[2][1] = "jhuiuu";*/
		
		return excelData;

	}
}
