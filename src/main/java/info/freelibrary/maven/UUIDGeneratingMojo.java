
package info.freelibrary.maven;

import static info.freelibrary.util.Constants.BUNDLE_NAME;

import java.util.UUID;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import info.freelibrary.util.Logger;
import info.freelibrary.util.LoggerFactory;
import info.freelibrary.util.MessageCodes;

/**
 * A Maven mojo that can generate UUIDs as a part of the build process.
 */
@Mojo(name = "set-uuid-property", defaultPhase = LifecyclePhase.INITIALIZE)
public class UUIDGeneratingMojo extends AbstractMojo {

    private static final Logger LOGGER = LoggerFactory.getLogger(UUIDGeneratingMojo.class, BUNDLE_NAME);

    /**
     * The Maven project directory.
     */
    @Parameter(defaultValue = "${project}")
    protected MavenProject myProject;

    /**
     * An optional String value from which to construct the UUID.
     */
    @Parameter(alias = "string")
    private String myString;

    /**
     * An optional build property name for the requested UUID.
     */
    @Parameter(alias = "name", defaultValue = "uuid")
    private String myName;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        final String uuid = myString == null ? UUID.randomUUID().toString() : UUID.fromString(myString).toString();

        LOGGER.debug(MessageCodes.MVN_013, myName, uuid);
        myProject.getProperties().setProperty(myName, uuid);
    }

}
