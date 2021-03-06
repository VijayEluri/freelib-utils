
package info.freelibrary.util;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.jar.JarFile;

import org.junit.Test;

/**
 * Tests the {@link ClasspathUtils} class.
 */
public class ClasspathUtilsTest {

    /**
     * Test method for {@link ClasspathUtils#getDirs()}.
     */
    @Test
    public void testGetDirs() {
        for (final String filename : ClasspathUtils.getDirs()) {
            if (!new File(filename).isDirectory()) {
                fail(filename + " isn't a directory as expected");
            }
        }
    }

    /**
     * Test method for {@link ClasspathUtils#getDirFiles()}.
     */
    @Test
    public void testGetDirFiles() {
        for (final File file : ClasspathUtils.getDirFiles()) {
            if (!file.isDirectory()) {
                fail(file.getAbsolutePath() + " isn't a directory as expected");
            }
        }
    }

    /**
     * Test method for {@link ClasspathUtils#getDirs(java.io.FilenameFilter)} .
     */
    @Test
    public void testGetDirsFilenameFilter() {
        final RegexDirFilter filter = new RegexDirFilter("(.*)t-classes");
        final int count = ClasspathUtils.getDirs(filter).length;

        if (count != 1) {
            fail("Expected to find 1 matches for regex but found " + count);
        }
    }

    /**
     * Test method for {@link ClasspathUtils#getDirFiles(java.io.FilenameFilter)} .
     */
    @Test
    public void testGetDirFilesFilenameFilter() {
        final RegexDirFilter filter = new RegexDirFilter("(.*)t-classes");
        final int count = ClasspathUtils.getDirFiles(filter).length;

        if (count != 1) {
            fail("Expected to find 1 matches for regex but found " + count);
        }
    }

    /**
     * Test method for {@link ClasspathUtils#getJars()}.
     */
    @Test
    public void testGetJars() {
        for (final String jarName : ClasspathUtils.getJars()) {
            if (!jarName.endsWith(".jar")) {
                fail(jarName + " doesn't have a .jar extension as expected");
            }
        }
    }

    /**
     * Test method for {@link ClasspathUtils#getJars(java.io.FilenameFilter)} .
     */
    @Test
    public void testGetJarsFilenameFilter() {
        final RegexFileFilter filter = new RegexFileFilter("^junit(.*)$");

        if (ClasspathUtils.getJars(filter).length != 1) {
            fail("Should have found one and only one junit jar file");
        }
    }

    /**
     * Test method for {@link ClasspathUtils#getJarFiles()}.
     */
    @Test
    public void testGetJarFiles() {
        try {
            for (final JarFile jarFile : ClasspathUtils.getJarFiles()) {
                if (!jarFile.getName().endsWith(".jar")) {
                    fail(jarFile.getName() + " is not a jar file");
                }
            }
        } catch (final IOException details) {
            fail(details.getMessage());
        }
    }

    /**
     * Test method for {@link ClasspathUtils#getJarFiles(java.io.FilenameFilter)} .
     */
    @Test
    public void testGetJarFilesFilenameFilter() {
        try {
            final RegexFileFilter filter = new RegexFileFilter("^junit(.*)$");
            final JarFile[] jars = ClasspathUtils.getJarFiles(filter);

            if (jars.length < 1) {
                fail("Failed to find junit jar file using regexp filter");
            }
        } catch (final IOException details) {
            fail(details.getMessage());
        }
    }

    /**
     * Test method for {@link ClasspathUtils#findFirst(java.lang.String)}.
     */
    @Test
    public void testFindFirst() {
        try {
            // Looking for a file at the root of a dir in the classpath
            if (!ClasspathUtils.find("freelib-utils_messages.xml")) {
                fail("Didn't find freelib-utils_messages.xml like it should");
            }

            // Looking for a class file that is buried in a dir structure
            if (!ClasspathUtils.find("info/freelibrary/util/StringUtils.class")) {
                fail("Didn't find expected info/freelibrary/util/StringUtils.class");
            }

            // Looking for something that doesn't exist
            if (ClasspathUtils.find("SOMETHING_NOT_FOUND")) {
                fail("Found SOMETHING_NOT_FOUND when it shouldn't have");
            }

            // Looking inside a jar file for its manifest
            if (!ClasspathUtils.find("META-INF/MANIFEST.MF")) {
                fail("Didn't find META-INF/MANIFEST.MF like it should");
            }
        } catch (final IOException details) {
            fail(details.getMessage());
        }
    }

}
