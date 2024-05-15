package es.tiernoparla.daw.mercadaw.utils.writer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class WordUtil extends DocumentoUtil{

    @Override
    public byte[] crearFichero(Documento doc) throws IOException {

        final String MSG_COLOR ="009933";
        final String MSG_FUENTE="Courier";
        final int MSG_TAMANYO=20;
        final String VACIO="";
        final String ESPACIO=" ";

        XWPFDocument document = new XWPFDocument();

        XWPFParagraph title = document.createParagraph();
        title.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleRun = title.createRun();
        titleRun.setText(doc.getTitulo());
        titleRun.setColor(MSG_COLOR);
        titleRun.setBold(true);
        titleRun.setFontFamily(MSG_FUENTE);
        titleRun.setFontSize(MSG_TAMANYO);

        Map<String, Object[]> data = doc.getContenido();
        Set<String> keyset = data.keySet(); 
        for (String key : keyset) { 
            Object[] objArr = data.get(key); 
            String parrafo = VACIO;
            for (Object obj : objArr) { 
                parrafo += obj.toString()+ESPACIO;
            }

            XWPFParagraph para1 = document.createParagraph();
            para1.setAlignment(ParagraphAlignment.BOTH);
            XWPFRun para1Run = para1.createRun();
            para1Run.setText(parrafo);
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        document.write(out);
        out.close();
        return out.toByteArray();
    }

}
