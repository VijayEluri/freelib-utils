/**
 * Licensed under the GNU LGPL v.2.1 or later.
 */

package info.freelibrary.util;

import static info.freelibrary.util.Constants.BUNDLE_NAME;

/**
 * Allows timing of the execution of any block of code.
 *
 * @author <a href="mailto:ksclarke@ksclarke.io">Kevin S. Clarke</a>
 */
public final class Stopwatch {

    private static final Logger LOGGER = LoggerFactory.getLogger(Stopwatch.class, BUNDLE_NAME);

    private boolean myTimerIsRunning;

    private long myStart;

    private long myStop;

    /**
     * Start the stopwatch.
     *
     * @throws IllegalStateException if the stopwatch is already running.
     * @return The stopwatch
     */
    public Stopwatch start() {
        if (myTimerIsRunning) {
            throw new IllegalStateException(LOGGER.getI18n(MessageCodes.UTIL_040));
        }

        myStart = System.currentTimeMillis();
        myTimerIsRunning = true;

        return this;
    }

    /**
     * Stop the stopwatch.
     *
     * @throws IllegalStateException if the stopwatch is not already running.
     * @return The stopwatch
     */
    public Stopwatch stop() {
        if (!myTimerIsRunning) {
            throw new IllegalStateException(LOGGER.getI18n(MessageCodes.UTIL_041));
        }

        myStop = System.currentTimeMillis();
        myTimerIsRunning = false;

        return this;
    }

    /**
     * Stop the stopwatch (as soon as possible) after a certain number of seconds.
     *
     * @param aSecondsCount A number of seconds after which to stop the stopwatch
     * @throws IllegalStateException if the stopwatch is not already running.
     * @return The stopwatch
     */
    public Stopwatch stopAfter(final int aSecondsCount) {
        if (!myTimerIsRunning) {
            throw new IllegalStateException(LOGGER.getI18n(MessageCodes.UTIL_041));
        }

        int stopCount = aSecondsCount;

        while (stopCount < aSecondsCount) {
            stopCount = (int) (System.currentTimeMillis() - myStart) / 1000;
        }

        myStop = System.currentTimeMillis();
        myTimerIsRunning = false;

        return this;
    }

    /**
     * Express the "reading" on the stopwatch in seconds.
     *
     * @return Time elapsed in stopwatch in seconds
     * @throws IllegalStateException if the Stopwatch has never been used, or if the stopwatch is still running.
     */
    public String getSeconds() {
        if (myTimerIsRunning) {
            throw new IllegalStateException(LOGGER.getI18n(MessageCodes.UTIL_042));
        }

        final StringBuilder result = new StringBuilder();
        final long timeGap = myStop - myStart;

        return result.append(timeGap / 1000).append(" secs, ").append(timeGap % 1000).append(" msecs ").toString();
    }

    /**
     * Express the "reading" on the stopwatch in milliseconds.
     *
     * @return Time elapsed in stopwatch in milliseconds
     * @throws IllegalStateException if the Stopwatch has never been used, or if the stopwatch is still running.
     */
    public String getMilliseconds() {
        if (myTimerIsRunning) {
            throw new IllegalStateException(LOGGER.getI18n(MessageCodes.UTIL_042));
        }

        return new StringBuilder().append(myStop - myStart).append(" msecs").toString();
    }

    /**
     * Returns a string representation of the time elapsed in milliseconds.
     *
     * @return Number of milliseconds elapsed in stopwatch
     */
    @Override
    public String toString() {
        return "Stopwatch milliseconds elapsed: " + getMilliseconds();
    }

}
