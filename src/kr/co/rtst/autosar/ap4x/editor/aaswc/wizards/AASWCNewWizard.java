package kr.co.rtst.autosar.ap4x.editor.aaswc.wizards;

import org.artop.aal.common.metamodel.AutosarReleaseDescriptor;
import org.artop.aal.workspace.preferences.IAutosarWorkspacePreferences;
import org.artop.aal.workspace.ui.wizards.BasicAutosarFileWizard;
import org.artop.aal.workspace.ui.wizards.pages.NewAutosarFileCreationPage;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.sphinx.emf.workspace.ui.wizards.pages.NewModelFileCreationPage;
import org.eclipse.ui.INewWizard;

/**
 * This is a sample new wizard. Its role is to create a new file 
 * resource in the provided container. If the container resource
 * (a folder or a project) is selected in the workspace 
 * when the wizard is opened, it will accept it as the target
 * container. The wizard creates one file with the extension
 * "aaswc". If a sample multi-page editor (also available
 * as a template) is registered for the same extension, it will
 * be able to open it.
 */

public class AASWCNewWizard extends BasicAutosarFileWizard implements INewWizard {
	
	@Override
	public boolean performFinish() {
		boolean result = super.performFinish();

		
		
		return result;
	}
	
	@Override
	protected NewModelFileCreationPage<AutosarReleaseDescriptor> createMainPage() {
//		return super.createMainPage();
		return new NewAASWCFileCreationPage("NewAutosarFileCreationPage", selection);
	}
	
	@Override
	protected Job createCreateNewModelFileJob(String jobName, IFile file) {
		// TODO Auto-generated method stub
		return new CreateNewAASWCFileJob(jobName, file, (AutosarReleaseDescriptor)IAutosarWorkspacePreferences.AUTOSAR_RELEASE.get(file.getProject()), ((NewAASWCFileCreationPage)mainPage).getInitialARPackageName(), ((NewAASWCFileCreationPage)mainPage).getAaswcModel());
//		return super.createCreateNewModelFileJob(jobName, file);
	}
	
}