
package info.freelibrary.util;

import org.slf4j.Marker;

/**
 * Create a SLF4J logger that is backed by a {@link java.util.ResourceBundle}.
 * 
 * @author <a href="mailto:ksclarke@gmail.com">Kevin S. Clarke</a>
 */
public class Logger extends I18nObject implements org.slf4j.Logger {

    private org.slf4j.Logger myLogger;

    /**
     * Creates a logger using the supplied class as the name.
     * 
     * @param aClass A class to use as the name of the logger
     */
    Logger(org.slf4j.Logger aLogger) {
        super();
        myLogger = aLogger;
    }

    /**
     * Creates a logger using the supplied class as the name.
     * 
     * @param aClass A class to use as the name of the logger
     */
    Logger(org.slf4j.Logger aLogger, String aBundleName) {
        super(aBundleName);
        myLogger = aLogger;
    }

    @Override
    public void debug(String aMessage) {
        if (hasI18nKey(aMessage)) {
            myLogger.debug(getI18n(aMessage));
        } else {
            myLogger.debug(aMessage);
        }
    }

    @Override
    public void debug(String aMessage, Object aDetail) {
        if (hasI18nKey(aMessage)) {
            myLogger.debug(getI18n(aMessage), aDetail);
        } else {
            myLogger.debug(aMessage, aDetail);
        }
    }

    @Override
    public void debug(String aMessage, Object... aVarargs) {
        if (hasI18nKey(aMessage)) {
            myLogger.debug(getI18n(aMessage), aVarargs);
        } else {
            myLogger.debug(aMessage, aVarargs);
        }
    }

    @Override
    public void debug(String aMessage, Throwable aThrowable) {
        if (hasI18nKey(aMessage)) {
            myLogger.debug(getI18n(aMessage), aThrowable);
        } else {
            myLogger.debug(aMessage, aThrowable);
        }
    }

    @Override
    public void debug(Marker aMarker, String aMessage) {
        if (hasI18nKey(aMessage)) {
            myLogger.debug(aMarker, getI18n(aMessage));
        } else {
            myLogger.debug(aMarker, aMessage);
        }
    }

    @Override
    public void debug(String aMessage, Object a1stDetail, Object a2ndDetail) {
        if (hasI18nKey(aMessage)) {
            myLogger.debug(getI18n(aMessage), a1stDetail, a2ndDetail);
        } else {
            myLogger.debug(aMessage, a1stDetail, a2ndDetail);
        }
    }

    @Override
    public void debug(Marker aMarker, String aMessage, Object aDetail) {
        if (hasI18nKey(aMessage)) {
            myLogger.debug(aMarker, getI18n(aMessage), aDetail);
        } else {
            myLogger.debug(aMarker, aMessage, aDetail);
        }
    }

    @Override
    public void debug(Marker aMarker, String aMessage, Object... aVarargs) {
        if (hasI18nKey(aMessage)) {
            myLogger.debug(aMarker, getI18n(aMessage), aVarargs);
        } else {
            myLogger.debug(aMarker, aMessage, aVarargs);
        }
    }

    @Override
    public void debug(Marker aMarker, String aMessage, Throwable aThrowable) {
        if (hasI18nKey(aMessage)) {
            myLogger.debug(aMarker, getI18n(aMessage), aThrowable);
        } else {
            myLogger.debug(aMarker, aMessage, aThrowable);
        }
    }

    @Override
    public void debug(Marker aMarker, String aMessage, Object a1stDetail,
            Object a2ndDetail) {
        if (hasI18nKey(aMessage)) {
            myLogger.debug(aMarker, getI18n(aMessage), a1stDetail, a2ndDetail);
        } else {
            myLogger.debug(aMarker, aMessage, a1stDetail, a2ndDetail);
        }
    }

    @Override
    public void error(String aMessage) {
        if (hasI18nKey(aMessage)) {
            myLogger.error(getI18n(aMessage));
        } else {
            myLogger.error(aMessage);
        }
    }

    @Override
    public void error(String aMessage, Object aDetail) {
        if (hasI18nKey(aMessage)) {
            myLogger.error(getI18n(aMessage), aDetail);
        } else {
            myLogger.error(aMessage, aDetail);
        }
    }

    @Override
    public void error(String aMessage, Object... aVarargs) {
        if (hasI18nKey(aMessage)) {
            myLogger.error(getI18n(aMessage), aVarargs);
        } else {
            myLogger.error(aMessage, aVarargs);
        }
    }

    @Override
    public void error(String aMessage, Throwable aThrowable) {
        if (hasI18nKey(aMessage)) {
            myLogger.error(getI18n(aMessage), aThrowable);
        } else {
            myLogger.error(aMessage, aThrowable);
        }
    }

    @Override
    public void error(Marker aMarker, String aMessage) {
        if (hasI18nKey(aMessage)) {
            myLogger.error(aMarker, getI18n(aMessage));
        } else {
            myLogger.error(aMarker, aMessage);
        }
    }

    @Override
    public void error(String aMessage, Object a1stDetail, Object a2ndDetail) {
        if (hasI18nKey(aMessage)) {
            myLogger.error(getI18n(aMessage), a1stDetail, a2ndDetail);
        } else {
            myLogger.error(aMessage, a1stDetail, a2ndDetail);
        }
    }

    @Override
    public void error(Marker aMarker, String aMessage, Object aDetail) {
        if (hasI18nKey(aMessage)) {
            myLogger.error(aMarker, getI18n(aMessage), aDetail);
        } else {
            myLogger.error(aMarker, aMessage, aDetail);
        }
    }

    @Override
    public void error(Marker aMarker, String aMessage, Object... aVarargs) {
        if (hasI18nKey(aMessage)) {
            myLogger.error(aMarker, getI18n(aMessage), aVarargs);
        } else {
            myLogger.error(aMarker, aMessage, aVarargs);
        }
    }

    @Override
    public void error(Marker aMarker, String aMessage, Throwable aThrowable) {
        if (hasI18nKey(aMessage)) {
            myLogger.error(aMarker, getI18n(aMessage), aThrowable);
        } else {
            myLogger.error(aMarker, aMessage, aThrowable);
        }
    }

    @Override
    public void error(Marker aMarker, String aMessage, Object a1stDetail,
            Object a2ndDetail) {
        if (hasI18nKey(aMessage)) {
            myLogger.error(aMarker, getI18n(aMessage), a1stDetail, a2ndDetail);
        } else {
            myLogger.error(aMarker, aMessage, a1stDetail, a2ndDetail);
        }
    }

    @Override
    public String getName() {
        return myLogger.getName();
    }

    @Override
    public void info(String aMessage) {
        if (hasI18nKey(aMessage)) {
            myLogger.info(getI18n(aMessage));
        } else {
            myLogger.info(aMessage);
        }
    }

    @Override
    public void info(String aMessage, Object aDetail) {
        if (hasI18nKey(aMessage)) {
            myLogger.info(getI18n(aMessage), aDetail);
        } else {
            myLogger.info(aMessage, aDetail);
        }
    }

    @Override
    public void info(String aMessage, Object... aVarargs) {
        if (hasI18nKey(aMessage)) {
            myLogger.info(getI18n(aMessage), aVarargs);
        } else {
            myLogger.info(aMessage, aVarargs);
        }
    }

    @Override
    public void info(String aMessage, Throwable aThrowable) {
        if (hasI18nKey(aMessage)) {
            myLogger.info(getI18n(aMessage), aThrowable);
        } else {
            myLogger.info(aMessage, aThrowable);
        }
    }

    @Override
    public void info(Marker aMarker, String aMessage) {
        if (hasI18nKey(aMessage)) {
            myLogger.info(aMarker, getI18n(aMessage));
        } else {
            myLogger.info(aMarker, aMessage);
        }
    }

    @Override
    public void info(String aMessage, Object a1stDetail, Object a2ndDetail) {
        if (hasI18nKey(aMessage)) {
            myLogger.info(getI18n(aMessage), a1stDetail, a2ndDetail);
        } else {
            myLogger.info(aMessage, a1stDetail, a2ndDetail);
        }
    }

    @Override
    public void info(Marker aMarker, String aMessage, Object aDetail) {
        if (hasI18nKey(aMessage)) {
            myLogger.info(aMarker, getI18n(aMessage), aDetail);
        } else {
            myLogger.info(aMarker, aMessage, aDetail);
        }
    }

    @Override
    public void info(Marker aMarker, String aMessage, Object... aVarargs) {
        if (hasI18nKey(aMessage)) {
            myLogger.info(aMarker, getI18n(aMessage), aVarargs);
        } else {
            myLogger.info(aMarker, aMessage, aVarargs);
        }
    }

    @Override
    public void info(Marker aMarker, String aMessage, Throwable aThrowable) {
        if (hasI18nKey(aMessage)) {
            myLogger.info(aMarker, getI18n(aMessage), aThrowable);
        } else {
            myLogger.info(aMarker, aMessage, aThrowable);
        }
    }

    @Override
    public void info(Marker aMarker, String aMessage, Object a1stDetail,
            Object a2ndDetail) {
        if (hasI18nKey(aMessage)) {
            myLogger.info(aMarker, getI18n(aMessage), a1stDetail, a2ndDetail);
        } else {
            myLogger.info(aMarker, aMessage, a1stDetail, a2ndDetail);
        }
    }

    @Override
    public boolean isDebugEnabled() {
        return myLogger.isDebugEnabled();
    }

    @Override
    public boolean isDebugEnabled(Marker aMarker) {
        return myLogger.isDebugEnabled(aMarker);
    }

    @Override
    public boolean isErrorEnabled() {
        return myLogger.isErrorEnabled();
    }

    @Override
    public boolean isErrorEnabled(Marker aMarker) {
        return myLogger.isErrorEnabled(aMarker);
    }

    @Override
    public boolean isInfoEnabled() {
        return myLogger.isInfoEnabled();
    }

    @Override
    public boolean isInfoEnabled(Marker aMarker) {
        return myLogger.isInfoEnabled(aMarker);
    }

    @Override
    public boolean isTraceEnabled() {
        return myLogger.isTraceEnabled();
    }

    @Override
    public boolean isTraceEnabled(Marker aMarker) {
        return myLogger.isTraceEnabled(aMarker);
    }

    @Override
    public boolean isWarnEnabled() {
        return myLogger.isWarnEnabled();
    }

    @Override
    public boolean isWarnEnabled(Marker aMarker) {
        return myLogger.isWarnEnabled(aMarker);
    }

    @Override
    public void trace(String aMessage) {
        if (hasI18nKey(aMessage)) {
            myLogger.trace(getI18n(aMessage));
        } else {
            myLogger.trace(aMessage);
        }
    }

    @Override
    public void trace(String aMessage, Object aDetail) {
        if (hasI18nKey(aMessage)) {
            myLogger.trace(getI18n(aMessage), aDetail);
        } else {
            myLogger.trace(aMessage, aDetail);
        }
    }

    @Override
    public void trace(String aMessage, Object... aVarargs) {
        if (hasI18nKey(aMessage)) {
            myLogger.trace(getI18n(aMessage), aVarargs);
        } else {
            myLogger.trace(aMessage, aVarargs);
        }
    }

    @Override
    public void trace(String aMessage, Throwable aThrowable) {
        if (hasI18nKey(aMessage)) {
            myLogger.trace(getI18n(aMessage), aThrowable);
        } else {
            myLogger.trace(aMessage, aThrowable);
        }
    }

    @Override
    public void trace(Marker aMarker, String aMessage) {
        if (hasI18nKey(aMessage)) {
            myLogger.trace(aMarker, getI18n(aMessage));
        } else {
            myLogger.trace(aMarker, aMessage);
        }
    }

    @Override
    public void trace(String aMessage, Object a1stDetail, Object a2ndDetail) {
        if (hasI18nKey(aMessage)) {
            myLogger.trace(getI18n(aMessage), a1stDetail, a2ndDetail);
        } else {
            myLogger.trace(aMessage, a1stDetail, a2ndDetail);
        }
    }

    @Override
    public void trace(Marker aMarker, String aMessage, Object aDetail) {
        if (hasI18nKey(aMessage)) {
            myLogger.trace(aMarker, getI18n(aMessage), aDetail);
        } else {
            myLogger.trace(aMarker, aMessage, aDetail);
        }
    }

    @Override
    public void trace(Marker aMarker, String aMessage, Object... aVarargs) {
        if (hasI18nKey(aMessage)) {
            myLogger.trace(aMarker, getI18n(aMessage), aVarargs);
        } else {
            myLogger.trace(aMarker, aMessage, aVarargs);
        }
    }

    @Override
    public void trace(Marker aMarker, String aMessage, Throwable aThrowable) {
        if (hasI18nKey(aMessage)) {
            myLogger.trace(aMarker, getI18n(aMessage), aThrowable);
        } else {
            myLogger.trace(aMarker, aMessage, aThrowable);
        }
    }

    @Override
    public void trace(Marker aMarker, String aMessage, Object a1stDetail,
            Object a2ndDetail) {
        if (hasI18nKey(aMessage)) {
            myLogger.trace(aMarker, getI18n(aMessage), a1stDetail, a2ndDetail);
        } else {
            myLogger.trace(aMarker, aMessage, a1stDetail, a2ndDetail);
        }
    }

    @Override
    public void warn(String aMessage) {
        if (hasI18nKey(aMessage)) {
            myLogger.warn(getI18n(aMessage));
        } else {
            myLogger.warn(aMessage);
        }
    }

    @Override
    public void warn(String aMessage, Object aDetail) {
        if (hasI18nKey(aMessage)) {
            myLogger.warn(getI18n(aMessage), aDetail);
        } else {
            myLogger.warn(aMessage, aDetail);
        }
    }

    @Override
    public void warn(String aMessage, Object... aVarargs) {
        if (hasI18nKey(aMessage)) {
            myLogger.warn(getI18n(aMessage), aVarargs);
        } else {
            myLogger.warn(aMessage, aVarargs);
        }
    }

    @Override
    public void warn(String aMessage, Throwable aThrowable) {
        if (hasI18nKey(aMessage)) {
            myLogger.warn(getI18n(aMessage), aThrowable);
        } else {
            myLogger.warn(aMessage, aThrowable);
        }
    }

    @Override
    public void warn(Marker aMarker, String aMessage) {
        if (hasI18nKey(aMessage)) {
            myLogger.warn(aMarker, getI18n(aMessage));
        } else {
            myLogger.warn(aMarker, aMessage);
        }
    }

    @Override
    public void warn(String aMessage, Object a1stDetail, Object a2ndDetail) {
        if (hasI18nKey(aMessage)) {
            myLogger.warn(getI18n(aMessage), a1stDetail, a2ndDetail);
        } else {
            myLogger.warn(aMessage, a1stDetail, a2ndDetail);
        }
    }

    @Override
    public void warn(Marker aMarker, String aMessage, Object aDetail) {
        if (hasI18nKey(aMessage)) {
            myLogger.warn(aMarker, getI18n(aMessage), aDetail);
        } else {
            myLogger.warn(aMarker, aMessage, aDetail);
        }
    }

    @Override
    public void warn(Marker aMarker, String aMessage, Object... aVarargs) {
        if (hasI18nKey(aMessage)) {
            myLogger.warn(aMarker, getI18n(aMessage), aVarargs);
        } else {
            myLogger.warn(aMarker, aMessage, aVarargs);
        }
    }

    @Override
    public void warn(Marker aMarker, String aMessage, Throwable aThrowable) {
        if (hasI18nKey(aMessage)) {
            myLogger.warn(aMarker, getI18n(aMessage), aThrowable);
        } else {
            myLogger.warn(aMarker, aMessage, aThrowable);
        }
    }

    @Override
    public void warn(Marker aMarker, String aMessage, Object a1stDetail,
            Object a2ndDetail) {
        if (hasI18nKey(aMessage)) {
            myLogger.warn(aMarker, getI18n(aMessage), a1stDetail, a2ndDetail);
        } else {
            myLogger.warn(aMarker, aMessage, a1stDetail, a2ndDetail);
        }
    }

}
