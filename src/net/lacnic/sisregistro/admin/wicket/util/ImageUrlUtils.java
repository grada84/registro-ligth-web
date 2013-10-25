package net.lacnic.sisregistro.admin.wicket.util;

public class ImageUrlUtils {

	public static String obtenerIconoDocumentoExtension(String extension) {
		if (extension.equals("doc") || extension.equals("docx")) {
			return "img/word.png";
		} else if (extension.equals("pdf")) {
			return "img/pdf.png";
		} else if (extension.equals("xls") || extension.equals("xlsx")) {
			return "img/excel.png";
		} else if (extension.equals("odt") || extension.equals("ods") || extension.equals("odp") || extension.equals("odg")) {
			return "img/openoffice.png";
		} else if (extension.equals("txt")) {
			return "img/txt.png";
		} else if (extension.equals("ppt") || extension.equals("pptx")) {
			return "img/ppt.png";
		} else if (extension.equals("jpg") || extension.equals("jpeg")) {
			return "img/jpg.png";
		} else if (extension.equals("zip")) {
			return "img/zip.png";
		} else if (extension.equals("png")) {
			return "img/png.png";
		} else if (extension.equals("rtf")) {
			return "img/rtf.png";
		} else if (extension.equals("html")) {
			return "img/html.png";
		} else if (extension.equals("log")) {
			return "img/log.png";
		} else {
			return "img/documents.png";
		}
	}

}
