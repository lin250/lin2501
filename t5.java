import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class d510050 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> fd = (ArrayList<String>) sql1
				.getas("select fdate from e order by fdate")
				.clone();
		ArrayList<String> fh = (ArrayList<String>) sql1
				.getas("select fh from e order by fdate")
				.clone();
		ArrayList<String> fl = (ArrayList<String>) sql1
				.getas("select fl from e order by fdate")
				.clone();
		ArrayList<String> fo = (ArrayList<String>) sql1
				.getas("select fo from e order by fdate")
				.clone();
		ArrayList<String> fc = (ArrayList<String>) sql1
				.getas("select fc from e order by fdate")
				.clone();

		// pA(fl);
		// check3(fl);
		// pi(fd.size());
		// pi(getbase(fh));

		// plot(fd,fh, fl, getbase(fh), fd.size());
		Document document = new Document();
		PdfContentByte canvas = null;
		try {
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream("c:\\t510050.pdf"));
			document.open();
			canvas = writer.getDirectContent();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		plot(canvas, fd, fh, fl, fo, fc, 0, fd.size(), 0.2f);
		document.close();
	}

	private static void plot(PdfContentByte c, ArrayList<String> fd,
			ArrayList<String> fh, ArrayList<String> fl, ArrayList<String> fo,
			ArrayList<String> fc, int base, int days, float lw) {

		c.saveState();
		c.setLineWidth(lw);

		for (int i = 0; i < days; i++) {
			if(Float.parseFloat(fo.get(i))>Float.parseFloat(fc.get(i))){
				
				c.moveTo(50+i*0.5, 50+Float.parseFloat(fh.get(i))*100);
				c.lineTo(50+i*0.5, 50+Float.parseFloat(fl.get(i))*100);
				c.stroke();
			}
			
		}

		c.restoreState();

	}

	private static void check3(ArrayList<String> fh) {
		for (int i = 0; i < fh.size(); i++)
			if (fh.get(i).length() == 3)
				ps(fh.get(i));

	}

	private static int getbase(ArrayList<String> aih) {
		// TODO Auto-generated method stub
		int max = 0, min = 99999;
		for (int i = 0; i < aih.size(); i++) {
			int j = (int) (Float.parseFloat(aih.get(i)) * 100);
			if (j > max)
				max = j;
		}
		max = ((max / 10) + 1) * 10;
		return max;
	}

	public static void pA(ArrayList<String> a) {
		for (int i = 0; i < a.size(); i++)
			System.out.println(a.get(i));
	}

	public static void pi(int s) {
		System.out.println(s);
	}

	public static void ps(String s) {
		System.out.println(s);
	}

}
