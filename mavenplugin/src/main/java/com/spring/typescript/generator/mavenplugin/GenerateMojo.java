package com.spring.typescript.generator.mavenplugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * Created by joao on 17/08/17.
 */

@Mojo(name = "generate",
        defaultPhase = LifecyclePhase.PACKAGE,
        requiresOnline = false,
        requiresProject = true,
        threadSafe = false)
public class GenerateMojo extends AbstractMojo {

    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Hello, world.");
    }
}
