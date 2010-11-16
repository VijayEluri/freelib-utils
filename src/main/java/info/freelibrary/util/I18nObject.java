package info.freelibrary.util;

import info.freelibrary.util.XMLBundleControl;
import info.freelibrary.util.XMLResourceBundle;

import java.io.File;
import java.util.ResourceBundle;

public abstract class I18nObject {

	private static final XMLResourceBundle BUNDLE = (XMLResourceBundle) ResourceBundle
			.getBundle("Messages", new XMLBundleControl());

	protected String getI18n(String aMessage) {
		return normalizeWS(BUNDLE.get(aMessage));
	}

	protected String getI18n(String aMessage, String aDetail) {
		return normalizeWS(BUNDLE.get(aMessage, aDetail));
	}

	protected String getI18n(String aMessage, String[] aDetailsArray) {
		return normalizeWS(BUNDLE.get(aMessage, aDetailsArray));
	}

	protected String getI18n(String aMessage, File aFile) {
		return normalizeWS(BUNDLE.get(aMessage, aFile.getAbsolutePath()));
	}

	protected String getI18n(String aMessage, File[] aFileArray) {
		String[] fileNames = new String[aFileArray.length];

		for (int index = 0; index < fileNames.length; index++) {
			fileNames[index] = aFileArray[index].getAbsolutePath();
		}

		return normalizeWS(BUNDLE.get(aMessage, fileNames));
	}

	protected String getI18n(String aMessage, Object[] aObjArray) {
		String[] strings = new String[aObjArray.length];

		for (int index = 0; index < aObjArray.length; index++) {
			if (aObjArray[index] instanceof File) {
				strings[index] = ((File) aObjArray[index]).getAbsolutePath();
			}
			else {
				strings[index] = aObjArray[index].toString();
			}
		}

		return normalizeWS(BUNDLE.get(aMessage, strings));
	}
	
	private String normalizeWS(String aMessage) {
		return aMessage.replaceAll("\\s+", " ");
	}
}
