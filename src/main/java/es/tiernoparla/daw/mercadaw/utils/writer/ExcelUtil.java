package es.tiernoparla.daw.mercadaw.utils.writer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil extends DocumentoUtil{
    
    @Override
    public byte[] crearFichero(Documento doc) throws IOException {

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet(doc.getTitulo());
    Map<String, Object[]> data = doc.getContenido();
	Set<String> keyset = data.keySet(); 
    int rownum = 0;

    for (String key : keyset) { 

        //Creamos una fila
        XSSFRow row = sheet.createRow(rownum++); 
        Object[] objArr = data.get(key); 
        int cellnum = 0; 

        for (Object obj : objArr) { 
            // Creamos una celda dentro de la fila
            XSSFCell cell = row.createCell(cellnum++); 
            if (obj instanceof String)
                cell.setCellValue((String)obj); 
            else if (obj instanceof Integer)
                cell.setCellValue((Integer)obj);
        }
    }     
        
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    workbook.write(out); 
    out.close();

    return out.toByteArray();
    }
}
