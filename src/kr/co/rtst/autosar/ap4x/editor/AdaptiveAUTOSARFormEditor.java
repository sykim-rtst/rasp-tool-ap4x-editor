package kr.co.rtst.autosar.ap4x.editor;

import org.artop.aal.examples.editor.AutosarFormEditor;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;

public abstract class AdaptiveAUTOSARFormEditor extends AutosarFormEditor/*BasicTransactionalFormEditor*/ {
	
	@Override
	public void init(IEditorSite site, IEditorInput editorInput) {
		// TODO Auto-generated method stub
		System.out.println("Input:"+editorInput);
		super.init(site, editorInput);
		
		Object o = getEditorInputObject();
		System.out.println("::::::::"+o);
		System.out.println("---"+getEditorInputName());
	}
	
	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		super.doSave(monitor);
	}
	
	@Override
	public void editorDirtyStateChanged() {
		// TODO Auto-generated method stub
		super.editorDirtyStateChanged();
	}

}
