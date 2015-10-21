import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.GrayColor;

public class PathConstructionAndPainting {

	public static final String RESULT = "paths.pdf";


	public void createPdf(String filename) throws IOException,
			DocumentException {
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream(filename));
		document.open();
		PdfContentByte canvas = writer.getDirectContent();
		//createSquares(canvas, 650, 0.5f, 0.2f);
		createSquares(canvas, 500, 0.5f, 0.5f);
		//createSquares(canvas, 350, 0.2f, 0.2f);
		//createSquares(canvas, 200, 0.2f, 0.5f);
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(""),
				50, 200, 0);
		document.close();
	}

	
	public void createSquares(PdfContentByte c, int base, float sk, float lw) {

		c.saveState();
		c.setLineWidth(lw);

		for (int i = 50; i < 550; i++) {
			int j = (int) (Math.random() * 150);
			int k = (int) (Math.random() * 150);
			int l = (int) (Math.random() * 150);
			int m = (int) (Math.random() * 150);
			int a[] = new int[4];
			a[0] = j;
			a[1] = k;
			a[2] = l;
			a[3] = m;
			Arrays.sort(a);
			if (j > k) {
				c.setColorStroke(new CMYKColor(0f, 0f, 0f, 1));

				c.moveTo(i, a[0]+base);
				c.lineTo(i, a[3]+base);
				c.stroke();
				c.setColorStroke(new CMYKColor(1f, 0f, 1f, 0));
				c.moveTo(i, a[1]+base);
				c.lineTo(i, a[2]+base);
				c.stroke();
			} else {
				c.setColorStroke(new CMYKColor(0f, 0f, 0f, 1));
				c.moveTo(i, a[0]+base);
				c.lineTo(i, a[3]+base);
				c.stroke();
				c.setColorStroke(new CMYKColor(0f, 1f, 1f, 0));
				c.moveTo(i, a[1]+base);
				c.lineTo(i, a[2]+base);c.stroke();
			}

		}

		c.stroke();

		c.restoreState();
	}

	
	public static void main(String[] args) throws IOException,
			DocumentException {
		new PathConstructionAndPainting().createPdf(RESULT);
	}
}
