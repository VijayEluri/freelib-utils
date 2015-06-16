
package info.freelibrary.util;

import java.util.Locale;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class I18nException extends Exception {

    /**
     * The <code>serialVersionUID</code> for the <code>I18nException</code>.
     */
    private static final long serialVersionUID = 1137212885016281357L;

    private static final Logger LOGGER = LoggerFactory.getLogger(I18nException.class);

    /**
     * Constructs a new <code>I18nException</code>.
     */
    public I18nException() {
        super();
    }

    /**
     * Constructs a new <code>I18nException</code> using the supplied bundle details.
     *
     * @param aBundleName The name of a resource bundle to use
     * @param aMessageKey The message key to retrieve from the supplied bundle
     */
    public I18nException(final String aBundleName, final String aMessageKey) {
        super(format(aBundleName, aMessageKey, (Object[]) new String[] {}));
    }

    /**
     * Constructs a new <code>I18nException</code> using the supplied {@link Locale} and bundle details.
     *
     * @param aLocale The {@link Locale} to use when looking up the message key
     * @param aBundleName The name of the resource bundle to use
     * @param aMessageKey The message key whose value should be retrieved from the supplied bundle
     */
    public I18nException(final Locale aLocale, final String aBundleName, final String aMessageKey) {
        super(format(aLocale, aBundleName, aMessageKey, new Object[] {}));
    }

    /**
     * Constructs a new <code>I18nException</code> with the supplied string as the message key and the supplied string
     * varargs as the message details.
     *
     * @param aBundleName The name of the resource bundle to use
     * @param aMessageKey The message key whose value should be retrieved from the supplied bundle
     * @param aVarargs The additional details to pass into the exception
     */
    public I18nException(final String aBundleName, final String aMessageKey, final Object... aVarargs) {
        super(format(aBundleName, aMessageKey, aVarargs));
    }

    /**
     * Constructs a new <code>I18nException</code> with the supplied {@link Locale} as the locale, the supplied int as
     * the message key, and the supplied string varargs as the message details.
     *
     * @param aLocale The locale to use when constructing the exception
     * @param aBundleName The name of the resource bundle to use
     * @param aMessageKey The key to use when looking up the message
     * @param aVarargs The additional details to pass into the exception
     */
    public I18nException(final Locale aLocale, final String aBundleName, final String aMessageKey,
            final Object... aVarargs) {
        super(format(aLocale, aBundleName, aMessageKey, aVarargs));
    }

    /**
     * Constructs a new <code>I18nException</code> with the supplied underlying cause.
     *
     * @param aCause The underlying cause of the current exception
     */
    public I18nException(final Throwable aCause) {
        super(aCause);
    }

    /**
     * Constructs a new <code>I18nException</code> with the supplied cause and message.
     *
     * @param aCause The underlying cause of the current exception
     * @param aBundleName The name of the resource bundle to use
     * @param aMessageKey The key to use when looking up the message
     */
    public I18nException(final Throwable aCause, final String aBundleName, final String aMessageKey) {
        super(format(aBundleName, aMessageKey, new Object[] {}), aCause);
    }

    /**
     * Constructs a new <code>I18nException</code> using the {@link Locale} with the supplied cause and message.
     *
     * @param aCause The underlying cause of the current exception
     * @param aLocale The locale to use when constructing the exception
     * @param aBundleName The name of the resource bundle to use
     * @param aMessageKey The key to use when looking up the message
     */
    public I18nException(final Throwable aCause, final Locale aLocale, final String aBundleName,
            final String aMessageKey) {
        super(format(aLocale, aBundleName, aMessageKey, new Object[] {}), aCause);
    }

    /**
     * Constructs a new <code>I18nException</code> with the supplied cause, message, and additional details.
     *
     * @param aCause The underlying cause of the current exception
     * @param aBundleName The name of the resource bundle to use
     * @param aMessageKey The key to use when looking up the message
     * @param aVarargs The additional details to add to the exception message
     */
    public I18nException(final Throwable aCause, final String aBundleName, final String aMessageKey,
            final Object... aVarargs) {
        super(format(aBundleName, aMessageKey, aVarargs), aCause);
    }

    /**
     * Constructs a new <code>I18nException</code> from the supplied {@link Locale} with the supplied cause, message,
     * and additional details.
     *
     * @param aCause The underlying cause of the current exception
     * @param aLocale The locale to use when constructing the exception
     * @param aBundleName The name of the resource bundle to use
     * @param aMessageKey The key to use when looking up the message
     * @param aVarargs The additional details to add to the exception message
     */
    public I18nException(final Throwable aCause, final Locale aLocale, final String aBundleName,
            final String aMessageKey, final Object... aVarargs) {
        super(format(aBundleName, aMessageKey, aVarargs), aCause);
    }

    /**
     * Constructs our I18n exception message using the supplied bundle name.
     *
     * @param aBundleName A name of a bundle in which to look up the supplied key.
     * @param aMessageKey A key value to look up in the <code>ResourceBundle</code>.
     * @param aVarargs Additional details to use in formatting the message.
     * @return A formatted exception message
     */
    private static String format(final String aBundleName, final String aMessageKey, final Object... aVarargs) {
        return format(null, aBundleName, aMessageKey, aVarargs);
    }

    /**
     * Constructs our I18n exception message using the supplied {@link Locale} and bundle name.
     *
     * @param aLocale A locale that should be used for the lookup of the message key.
     * @param aBundleName A name of a bundle in which to look up the supplied key.
     * @param aMessageKey A key value to look up in the <code>ResourceBundle</code>.
     * @param aVarargs Additional details to use in formatting the message.
     * @return A formatted exception message
     */
    private static String format(final Locale aLocale, final String aBundleName, final String aMessageKey,
            final Object... aVarargs) {
        XMLResourceBundle bundle;

        if (aBundleName == null) {
            throw new NullPointerException("Exception ResourceBundle name may not be null");
        } else if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Constructing exception message using bundle name: {}", aBundleName);
        }

        if (aMessageKey == null) {
            throw new NullPointerException("Exception message key may not be null");
        }

        if (aLocale != null) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Constructing exception message using supplied locale: {}", aLocale.toString());
            }

            bundle = (XMLResourceBundle) ResourceBundle.getBundle(aBundleName, aLocale, new XMLBundleControl());
        } else {
            bundle = (XMLResourceBundle) ResourceBundle.getBundle(aBundleName, new XMLBundleControl());
        }

        if (aVarargs != null && aVarargs.length > 0) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Formatting exception message for '{}' using: {} [{}]", aMessageKey, aVarargs, aVarargs
                        .getClass().getSimpleName());
            }

            return bundle.get(aMessageKey, aVarargs);
        } else {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Formatting exception message for '{}'", aMessageKey);
            }

            return bundle.get(aMessageKey);
        }
    }

}
