package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility
{
	/**
	 *
	 * @param sheetName
	 * @param rowno
	 * @param cellno
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName,int rowno,int cellno) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowno).getCell(cellno).getStringCellValue();
		return value;
	}
	/**
	 * This method will read multiple data from excel sheet
	 * @param sheetName
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();

		Object[][] data = new Object[lastRow][lastCell];

		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;i++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}

		}
		return data;
	}
}
