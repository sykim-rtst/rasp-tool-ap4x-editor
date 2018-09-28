package kr.co.rtst.autosar.ap4x.editor.aaswc.wizards;

import org.artop.aal.workspace.ui.wizards.pages.NewAutosarFileCreationPage;
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
	
	@Override
	protected String getDefaultBaseName() {
		return super.getDefaultBaseName();
	}
	
	@Override
	protected String getDefaultFileExtension() {
		return "aaswc";
	}
	
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

}
