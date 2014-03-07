/**
 * Licensed under the GNU LGPL v.2.1 or later.
 */

package info.freelibrary.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * A {@link FilenameFilter} that allows filtering file names based on regular expressions.
 * 
 * @author <a href="mailto:ksclarke@gmail.com">Kevin S. Clarke</a>
 */
public class RegexFileFilter implements FilenameFilter {

    private Pattern myPattern;

    /**
     * Constructor for a regular expression {@link FilenameFilter}.
     * 
     * @param aPattern The regular expression for the filter
     */
    public RegexFileFilter(String aPattern) {
        this(aPattern, false);
    }

    /**
     * Constructor for a regular expression {@link FilenameFilter} that creates a case insensitive.
     * 
     * @param aPattern The regular expression for the filter
     */
    public RegexFileFilter(String aPattern, boolean aCaseInsensitivePattern) {
        if (aCaseInsensitivePattern) {
            myPattern = Pattern.compile(aPattern, Pattern.CASE_INSENSITIVE);
        } else {
            myPattern = Pattern.compile(aPattern);
        }
    }

    /**
     * Determines whether the supplied {@link File} in the supplied directory should be included.
     * 
     * @param aDir The directory in which the {@link File} of the file name lives
     * @param aFilename A {@link File} name to compare against the regular expression; it must be a file (not a
     *        directory)
     */
    public boolean accept(File aDir, String aFilename) {
        return new File(aDir, aFilename).isFile() && myPattern.matcher(aFilename).matches();
    }

}
