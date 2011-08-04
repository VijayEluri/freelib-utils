package info.freelibrary.util;

/*

 ===============================================================================
 This class (Pairtree) was originally written by Justin Littman (jlit@loc.gov)
 It has been modified and renamed by Kevin S. Clarke (ksclarke@gmail.com)
 ===============================================================================

 This software is a work of the United States Government and is not subject 
 to copyright protection in the United States. 

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR THE UNITED STATES BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.


 Foreign copyrights may apply. To the extent that foreign copyrights in the 
 software exist outside the United States, the following terms apply:

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.

 */

import java.io.File;
import java.io.UnsupportedEncodingException;

import java.util.ArrayList;
import java.util.List;

public class PairtreeUtils {

	public static final String HEX_INDICATOR = "^";

	private static Character mySeparator = File.separatorChar;

	private static int myShortyLength = 2;

	public static int getShortyLength() {
		return myShortyLength;
	}

	public static void setShortyLength(int length) {
		myShortyLength = length;
	}

	public static Character getSeparator() {
		return mySeparator;
	}

	public static void setSeparator(Character separator) {
		mySeparator = separator;
	}

	public static String mapToPPath(String id) {
		assert id != null;
		
		String cleanId = cleanId(id);
		List<String> shorties = new ArrayList<String>();
		int start = 0;
		
		while (start < cleanId.length()) {
			int end = start + myShortyLength;
			
			if (end > cleanId.length()) {
				end = cleanId.length();
			}
			
			shorties.add(cleanId.substring(start, end));
			start = end;
		}
		return concat(shorties.toArray(new String[] {}));
	}

	public static String mapToPPath(String basePath, String id) {
		return concat(basePath, mapToPPath(id), null);
	}
	
	public static String mapToPPath(String basePath, String id,
			String encapsulatingDirName) {
		return concat(basePath, mapToPPath(id), encapsulatingDirName);
	}

	public static String mapToId(String basepath, String ppath)
			throws InvalidPpathException {
		String newPath = removeBasepath(basepath, ppath);
		return mapToId(newPath);
	}

	public static String mapToId(String ppath) throws InvalidPpathException {
		String id = ppath;

		if (id.endsWith(Character.toString(mySeparator))) {
			id = id.substring(0, id.length() - 1);
		}

		String encapsulatingDir = extractEncapsulatingDirFromPpath(ppath);

		if (encapsulatingDir != null) {
			id = id.substring(0, id.length() - encapsulatingDir.length());
		}

		id = id.replace(Character.toString(mySeparator), "");
		id = uncleanId(id);

		return id;
	}

	public static String extractEncapsulatingDirFromPpath(String basepath,
			String ppath) throws InvalidPpathException {
		String newPath = removeBasepath(basepath, ppath);
		return extractEncapsulatingDirFromPpath(newPath);
	}

	public static String extractEncapsulatingDirFromPpath(String ppath)
			throws InvalidPpathException {
		assert ppath != null;

		// Walk the ppath looking for first non-shorty
		String[] ppathParts = ppath.split("\\" + mySeparator);

		// If there is only 1 part
		if (ppathParts.length == 1) {
			// If part <= shorty length then no encapsulating dir
			if (ppathParts[0].length() <= myShortyLength) {
				return null;
			}
			// Else no ppath
			else {
				throw new InvalidPpathException(StringUtils.formatMessage(
						"Ppath ({}) contains no shorties", ppath));
			}
		}

		// All parts up to next to last and last should have shorty length
		for (int i = 0; i < ppathParts.length - 2; i++) {
			if (ppathParts[i].length() != myShortyLength) {
				throw new InvalidPpathException(StringUtils.formatMessage(
						"Ppath ({}) has parts of incorrect length", ppath));
			}
		}

		String nextToLastPart = ppathParts[ppathParts.length - 2];
		String lastPart = ppathParts[ppathParts.length - 1];

		// Next to last should have shorty length or less
		if (nextToLastPart.length() > myShortyLength) {
			throw new InvalidPpathException(StringUtils.formatMessage(
					"Ppath ({}) has parts of incorrect length", ppath));
		}

		// If next to last has shorty length
		if (nextToLastPart.length() == myShortyLength) {
			// If last has length > shorty length then encapsulating dir
			if (lastPart.length() > myShortyLength) {
				return lastPart;
			}
			// Else no encapsulating dir
			else {
				return null;
			}
		}

		// Else last is encapsulating dir
		return lastPart;

	}

	private static String concat(String... paths) {
		if (paths == null || paths.length == 0) {
			return null;
		}

		StringBuffer pathBuf = new StringBuffer();
		Character lastChar = null;

		for (int i = 0; i < paths.length; i++) {
			if (paths[i] != null) {
				if (lastChar != null && (!mySeparator.equals(lastChar))) {
					pathBuf.append(mySeparator);
				}

				pathBuf.append(paths[i]);
				lastChar = paths[i].charAt(paths[i].length() - 1);
			}
		}

		return pathBuf.toString();
	}

	public static String removeBasepath(String basePath, String path) {
		assert basePath != null;
		assert path != null;
		String newPath = path;

		if (path.startsWith(basePath)) {
			newPath = newPath.substring(basePath.length());
			
			if (newPath.startsWith(Character.toString(mySeparator))) {
				newPath = newPath.substring(1);
			}
		}

		return newPath;
	}

	public static String cleanId(String id) {
		assert id != null;
		// First pass
		byte[] bytes;
		
		try {
			bytes = id.getBytes("utf-8");
		}
		catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Error getting UTF-8 for path", e);
		}

		StringBuffer idBuf = new StringBuffer();

		for (int c = 0; c < bytes.length; c++) {
			byte b = bytes[c];
			int i = (int) b & 0xff;

			if (i < 0x21 || i > 0x7e || i == 0x22 || i == 0x2a || i == 0x2b
					|| i == 0x2c || i == 0x3c || i == 0x3d || i == 0x3e
					|| i == 0x3f || i == 0x5c || i == 0x5e || i == 0x7c) {
				// Encode
				idBuf.append(HEX_INDICATOR);
				idBuf.append(Integer.toHexString(i));
			}
			else {
				// Don't encode
				char[] chars = Character.toChars(i);
				
				assert chars.length == 1;
				idBuf.append(chars[0]);
			}
		}

		for (int c = 0; c < idBuf.length(); c++) {
			char ch = idBuf.charAt(c);
			
			if (ch == '/') {
				idBuf.setCharAt(c, '=');
			}
			else if (ch == ':') {
				idBuf.setCharAt(c, '+');
			}
			else if (ch == '.') {
				idBuf.setCharAt(c, ',');
			}
		}

		return idBuf.toString();
	}

	public static String uncleanId(String id) {
		StringBuffer idBuf = new StringBuffer();

		for (int c = 0; c < id.length(); c++) {
			char ch = id.charAt(c);
			
			if (ch == '=') {
				idBuf.append('/');
			}
			else if (ch == '+') {
				idBuf.append(':');
			}
			else if (ch == ',') {
				idBuf.append('.');
			}
			else if (ch == '^') {
				// Get the next 2 chars
				String hex = id.substring(c + 1, c + 3);
				char[] chars = Character.toChars(Integer.parseInt(hex, 16));
				
				assert chars.length == 1;
				idBuf.append(chars[0]);
				c = c + 2;
			}
			else {
				idBuf.append(ch);
			}
		}

		return idBuf.toString();
	}
}
