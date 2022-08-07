package testngretryngroups;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeadData  {

	public static String[][] getLeadDatas(String file) throws IOException {
		XSSFWorkbook book = new XSSFWorkbook("./datas/"+file+".xlsx");
		XSSFSheet sheet = book.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(1).getLastCellNum();
		String[][] data = new String[rowCount][columnCount];
		for (int i = 1; i<=rowCount; i++) {
			for (int j = 0; j<columnCount; j++) {
				String cellValue = sheet.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = cellValue; 
				}
			}
		book.close();
		return data;
		}
}
