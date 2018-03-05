package com.spring.typescript.generator.mavenplugin;

import com.spring.typescript.generator.mavenplugin.model.Parametros;
import com.spring.typescript.generator.mavenplugin.service.PluginService;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.descriptor.PluginDescriptor;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.classworlds.realm.ClassRealm;

import java.io.File;
import java.util.List;

/**
 * Created by joao on 17/08/17.
 */

@Mojo(name = "generate",
        defaultPhase = LifecyclePhase.PROCESS_CLASSES,
        threadSafe = true)
public class GenerateMojo extends AbstractMojo {

    @Component
    private MavenProject project;

    @Component
    private PluginDescriptor descriptor;

    @Parameter
    private String destination;

    public void execute() {
        try {
            List<String> runtimeClasspathElements = project.getRuntimeClasspathElements();
            ClassRealm realm = descriptor.getClassRealm();

            for (String element : runtimeClasspathElements) {
                File elementFile = new File(element);
                realm.addURL(elementFile.toURI().toURL());
            }

            new PluginService().buid(new Parametros(destination));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
