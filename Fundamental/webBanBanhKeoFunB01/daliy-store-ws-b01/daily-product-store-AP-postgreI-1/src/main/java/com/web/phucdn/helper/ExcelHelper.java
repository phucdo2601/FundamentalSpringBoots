package com.web.phucdn.helper;

import java.io.IOException;
import java.io.InputStream;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.web.phucdn.models.ProductBrand;

public class ExcelHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	public static String[] HEADERs = { "brand_code", "brand_name" };
	public static String SHEET = "ProductBrands";

	private static final ZoneId ZONE_ID = ZoneId.of("Asia/Bangkok");

	public static boolean hasExcelFormat(MultipartFile file) {
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	public static List<ProductBrand> excelToProductBrands(InputStream is) {
		try {
			Workbook workbook = new XSSFWorkbook(is);
			Sheet sheet = workbook.getSheet(SHEET);

			Iterator<Row> rows = sheet.iterator();

			List<ProductBrand> listProductBrands = new ArrayList<>();

			int rowNumber = 0;

			while (rows.hasNext()) {
				Row currentRow = rows.next();

				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();

				ProductBrand productBrand = new ProductBrand();

				int cellIdx = 0;

				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();

					switch (cellIdx) {
					case 0:
						productBrand.setBrandCode(currentCell.getStringCellValue());
						break;

					case 1:
						productBrand.setBrandName(currentCell.getStringCellValue());
						break;

					case 2:
						productBrand.setDescription(currentCell.getStringCellValue());
						break;
					default:
						break;
					}

					cellIdx++;
				}

				productBrand.setDateOfCreate(GeneralHelper.getcurrentTimeStamp(ZONE_ID));
				listProductBrands.add(productBrand);
			}
			workbook.close();

			return listProductBrands;

		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
}
