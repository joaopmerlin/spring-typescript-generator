package com.spring.typescript.generator.mavenplugin;

import com.spring.typescript.generator.annotation.EnableSpringTypescriptGenerator;
import com.spring.typescript.generator.annotation.TsModel;
import com.spring.typescript.generator.annotation.TsService;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.descriptor.PluginDescriptor;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.classworlds.realm.ClassRealm;
import org.reflections.Reflections;

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

    /*@Parameter(defaultValue = "${session}", readonly = true)
    private MavenSession mavenSession;

    @Parameter(required = true, defaultValue="${project.build.directory}")
    private File sourceDirectory;

    @Component
    private BuildPluginManager pluginManager;*/

    @Component
    private PluginDescriptor descriptor;

    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Hello, world.");

        try {

            List<String> runtimeClasspathElements = project.getRuntimeClasspathElements();
            ClassRealm realm = descriptor.getClassRealm();

            for (String element : runtimeClasspathElements) {
                File elementFile = new File(element);
                realm.addURL(elementFile.toURI().toURL());
            }

            Reflections ref = new Reflections();
            ref.getTypesAnnotatedWith(EnableSpringTypescriptGenerator.class);
            ref.getTypesAnnotatedWith(TsModel.class);
            ref.getTypesAnnotatedWith(TsService.class);

            /*File classesDirectory = new File(sourceDirectory.getAbsolutePath() + "/classes");
            URL classesUrl = classesDirectory.toURI().toURL();
            URL[] classesUrls = new URL[]{classesUrl};

            // Make sure to use the URLClassLoader, using the simple ClassLoader WILL NOT WORK for reading the annotations
            URLClassLoader classLoader = URLClassLoader.newInstance(classesUrls, getClass().getClassLoader());

            // Load our remote class file found out in the "/classes" directory
            Class classObject = classLoader.loadClass("com.my.services.AuthenticationService");;

            // Check to make sure the class has the annotation
            if(classObject.isAnnotationPresent(TsModel.class))
            {
                // Get the annotation and print the value
                TsModel annotation = (TsModel)classObject.getAnnotation(TsModel.class);
                System.out.println("Annotation value is: " + annotation.value());
            }*/
        } catch (Exception e) {

        }

    }
}
