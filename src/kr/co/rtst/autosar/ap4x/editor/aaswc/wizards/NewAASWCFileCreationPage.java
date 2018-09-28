package kr.co.rtst.autosar.ap4x.editor.aaswc.wizards;

import java.util.Collection;

import org.artop.aal.workspace.ui.wizards.pages.NewAutosarFileCreationPage;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class NewAASWCFileCreationPage extends NewAutosarFileCreationPage {

	private AdaptiveApplicationSWCTypeCreationModel aaswcModel;
	
	public NewAASWCFileCreationPage(String pageId, IStructuredSelection selection) {
		super(pageId, selection);
		aaswcModel = new AdaptiveApplicationSWCTypeCreationModel();
	}
	
//	@Override
//	protected String getDefaultBaseName() {
//		return super.getDefaultBaseName();
//	}
//	
//	@Override
//	protected String getDefaultFileExtension() {
//		return "aaswc";
//	}
//	
//	@Override
//	protected Collection<String> getValidFileExtensions() {
//		// TODO Auto-generated method stub
//		Collection<String> original = super.getValidFileExtensions();
//		return original;
//	}
	
	@Override
	protected void createAdditionalControls(Composite parent) {
		// TODO Auto-generated method stub
		super.createAdditionalControls(parent);
		
		createInitialAASWCShortNameGroup(parent);
	}
	
	public AdaptiveApplicationSWCTypeCreationModel getAaswcModel() {
		return aaswcModel;
	}
	
	protected void createInitialAASWCShortNameGroup(Composite parent) {
        Group group = new Group(parent, SWT.NONE);
        group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        group.setLayout(new GridLayout(2, false));
        group.setText("Adaptive Application SWC Type creation");
        
        Label label = new Label(group, SWT.NONE);
        label.setText("Short Name: ");
        
        final Text txtShortName = new Text(group, SWT.BORDER);
        txtShortName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtShortName.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				aaswcModel.setShortName(txtShortName.getText());
			}
		});
    }
	
	@Override
	protected String getContentTypeId() {
//		return super.getContentTypeId();
		return "kr.co.rtst.autosar.ap4x.core.contenttype.aaswcFile";
	}
	
	@Override
	protected boolean validatePage() {
        if(!super.validatePage())
            return false;
        IProject containerProject = getContainerProject();
        if(containerProject != null && !hasRequiredProjectNature(containerProject))
        {
            setErrorMessage(getRequiredProjectNatureErrorMessage());
            return false;
        }
        if(containerProject != null && !hasMatchingMetaModelVersion(containerProject))
        {
            setErrorMessage(getMatchingMetaModelVersionErrorMessage());
            return false;
        }
        String fileExtension = (new Path(getFileName())).getFileExtension();
        Collection validFileExtensions = getValidFileExtensions();
        System.out.println("TYPE:"+getContentTypeId()); 
        validFileExtensions.stream().forEach(e->{
        	System.out.println(":::::::"+e);
        });
        if(!validFileExtensions.isEmpty() && !validFileExtensions.contains(fileExtension))
        {
            setErrorMessage(getFileExtensionErrorMessage(validFileExtensions));
            return false;
        } 
        else {
            return true;
        }
    }

}
