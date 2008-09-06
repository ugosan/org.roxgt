package org.roxgt.project.builder;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.internal.registry.ExtensionRegistry;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.ui.ide.ResourceUtil;


public class RoxgtNature implements IProjectNature {

	/**
	 * ID of this project nature
	 */
	public static final String NATURE_ID = "org.roxgt.project.roxgtProject";

	private IProject project;


	ArrayList<String> plugins = new ArrayList<String>();
	public static final String ROXGT_CORE_PLUGIN_ID = "org.roxgt.core";
	
	public static final String ECLIPSE_VIEWS_PLUGIN_ID = "org.eclipse.ui.views";
	public static final String ECLIPSE_GEF_PLUGIN_ID = "org.eclipse.gef";
	public static final String ECLIPSE_CORE_RUNTIME_PLUGIN_ID = "org.eclipse.core.runtime";
	public static final String ECLIPSE_DRAW2D_PLUGIN_ID = "org.eclipse.draw2d";
	public static final String ECLIPSE_JFACE_PLUGIN_ID = "org.eclipse.jface";
	public static final String ECLIPSE_SWT_PLUGIN_ID = "org.eclipse.swt";
	public static final String ECLIPSE_SWT_LINUX_PLUGIN_ID = "org.eclipse.swt.gtk.linux.x86";
	public static final String ECLIPSE_SWT_WIN32_PLUGIN_ID = "org.eclipse.swt.win32.win32.x86";	
	public static final String ECLIPSE_EQUINOX_COMMON_PLUGIN_ID = "org.eclipse.equinox.common";
	
	public RoxgtNature() {
		super();
		plugins.add(ROXGT_CORE_PLUGIN_ID);
		plugins.add(ECLIPSE_CORE_RUNTIME_PLUGIN_ID);
		plugins.add(ECLIPSE_EQUINOX_COMMON_PLUGIN_ID);
		plugins.add(ECLIPSE_DRAW2D_PLUGIN_ID);
		plugins.add(ECLIPSE_GEF_PLUGIN_ID);
		plugins.add(ECLIPSE_JFACE_PLUGIN_ID);
		plugins.add(ECLIPSE_VIEWS_PLUGIN_ID);
		//plugins.add(ECLIPSE_SWT_PLUGIN_ID);
		//plugins.add(ECLIPSE_SWT_LINUX_PLUGIN_ID);
		//plugins.add(ECLIPSE_SWT_WIN32_PLUGIN_ID);
		plugins.add("org.eclipse.emf");
		plugins.add("org.eclipse.emf.ecore.xmi");
		plugins.add("org.eclipse.emf.ecore");
		plugins.add("org.eclipse.gmf.runtime.notation");
		plugins.add("org.eclipse.gmf.runtime.common.core");
		plugins.add("org.eclipse.gmf");
		plugins.add("org.eclipse.emf.common");
		plugins.add("org.roxgt.core.tests");
		
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IProjectNature#configure()
	 */
	public void configure() throws CoreException {
		IProjectDescription desc = project.getDescription();
		ICommand[] commands = desc.getBuildSpec();

		for (int i = 0; i < commands.length; ++i) {
			if (commands[i].getBuilderName().equals(RoxgtBuilder.BUILDER_ID)) {
				return;
			}
		}
		
		
		ICommand[] newCommands = new ICommand[commands.length + 1];
		System.arraycopy(commands, 0, newCommands, 0, commands.length);
		ICommand command = desc.newCommand();
		command.setBuilderName(RoxgtBuilder.BUILDER_ID);
		newCommands[newCommands.length - 1] = command;
		desc.setBuildSpec(newCommands);
		project.setDescription(desc, null);
		
		try{
			IJavaProject javaProject = JavaCore.create(project);

			IClasspathEntry[] original = javaProject.getRawClasspath();
			
			ArrayList<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();
			System.out.println(Platform.getInstallLocation());
			System.out.println(Platform.getLocation());
			System.out.println(Platform.getUserLocation());
			System.out.println(Platform.getInstanceLocation());
			
			for (String s : plugins) {
				if(Platform.getBundle(s)!=null){
					
					
					
					
					
					String[] splitted = Platform.getBundle(s).getLocation().split(":");
					String entry = splitted[splitted.length-1];
					System.out.println(Platform.getBundle(s).getLocation()+" - "+entry);
					if(entry.startsWith(".."))
						entries.add(JavaCore.newLibraryEntry(new Path("/home/ugo"+entry.substring(entry.indexOf("..")+2)+"bin"), null, null));
						else
						entries.add(JavaCore.newLibraryEntry(new Path("/home/ugo/eclipse3.4/"+entry), null, null));
				}
			}
			
			
			
			//entries.add(JavaCore.newVariableEntry(new Path("JRE_LIB"), new Path("JRE_SRC"), new Path("JRE_SRCROOT")));
			
			for (int i = 0; i < original.length; i++) {
				IClasspathEntry classpathEntry = original[i];
				entries.add(classpathEntry);
			}
			

			
			javaProject.setRawClasspath(entries.toArray(new IClasspathEntry[entries.size()]), null);


		}catch(Exception e){
			e.printStackTrace();
		}
	
	}

	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IProjectNature#deconfigure()
	 */
	public void deconfigure() throws CoreException {
		IProjectDescription description = getProject().getDescription();
		ICommand[] commands = description.getBuildSpec();
		for (int i = 0; i < commands.length; ++i) {
			if (commands[i].getBuilderName().equals(RoxgtBuilder.BUILDER_ID)) {
				ICommand[] newCommands = new ICommand[commands.length - 1];
				System.arraycopy(commands, 0, newCommands, 0, i);
				System.arraycopy(commands, i + 1, newCommands, i,
						commands.length - i - 1);
				description.setBuildSpec(newCommands);
				return;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IProjectNature#getProject()
	 */
	public IProject getProject() {
		return project;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IProjectNature#setProject(org.eclipse.core.resources.IProject)
	 */
	public void setProject(IProject project) {
		this.project = project;
	}

}
