package kr.co.rtst.autosar.ap4x.editor.aaswc.wizards;

import org.artop.aal.common.metamodel.AutosarReleaseDescriptor;
import org.artop.aal.workspace.jobs.CreateNewAutosarFileJob;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;

import autosar40.adaptiveplatform.applicationdesign.applicationstructure.AdaptiveApplicationSwComponentType;
import autosar40.adaptiveplatform.applicationdesign.applicationstructure.impl.ApplicationstructureFactoryImpl;
import gautosar.ggenericstructure.ginfrastructure.GAUTOSAR;

public class CreateNewAASWCFileJob extends CreateNewAutosarFileJob /*CreateNewModelFileJob*/ /*CreateNewAutosarFileJob*/ {

	private AdaptiveApplicationSWCTypeCreationModel aaswcModel;
	private IFile autosarFile;
	
	public CreateNewAASWCFileJob(String jobName, IFile autosarFile, AutosarReleaseDescriptor autosarRelease,
			String initialARPackageName, AdaptiveApplicationSWCTypeCreationModel aaswcModel) {
		super(jobName, autosarFile, autosarRelease, initialARPackageName);
		this.aaswcModel = aaswcModel;
		this.autosarFile = autosarFile;
	}
	
	@Override
	protected EObject createInitialModel() {
		// TODO Auto-generated method stub
		EObject object = super.createInitialModel();
		
		ApplicationstructureFactoryImpl appfactory = new ApplicationstructureFactoryImpl();
    	AdaptiveApplicationSwComponentType aaswc = appfactory.createAdaptiveApplicationSwComponentType();
    	aaswc.setShortName(aaswcModel.getShortName());
		
    	((GAUTOSAR)object).gGetArPackages().get(0).gGetElements().add(aaswc);
    	
//    	AutosarCoreModelRegistry.getInstance().putCoreModel(autosarFile, ((GAUTOSAR)object));
		return object;
	}

//    public CreateNewAASWCFileJob(String jobName, IFile autosarFile, AutosarReleaseDescriptor autosarRelease, String initialARPackageName)
//    {
//        super(jobName, autosarFile, autosarRelease, autosarRelease.getRootEPackage(), autosarRelease.getRootEPackage().getEClassifier("AUTOSAR"));
//        this.initialARPackageName = initialARPackageName;
//    }

//    protected EObject createInitialModel()
//    {
//        GAUTOSAR autosar = (GAUTOSAR)super.createInitialModel();
//        if(initialARPackageName != null)
//        {
//            IGAutosarFactoryService autosarFactory = getAutosarFactoryService();
//            if(autosarFactory != null)
//            {
//            	
////            	GApplicationSwComponentTypeBuilder.applicationSwComponent("TEST").;
////            	GRootSwCompositionPrototype swc = autosarFactory.createGRootSwCompositionPrototype();
////                swc.gSetShortName("TEST");
//
//                
//                GARPackage arPackage = autosarFactory.createGARPackage();
//                arPackage.gSetShortName(initialARPackageName);
//
//                ApplicationstructureFactoryImpl appfactory = new ApplicationstructureFactoryImpl();
//            	AdaptiveApplicationSwComponentType aaswc = appfactory.createAdaptiveApplicationSwComponentType();
//            	aaswc.setShortName("TEST");
//                
//                                
//                arPackage.gGetElements().add(aaswc);
//                autosar.gGetArPackages().add(arPackage);
//                
//                
//            }
//        }
//        return autosar;
//    }

//    protected IGAutosarFactoryService getAutosarFactoryService()
//    {
//        return (IGAutosarFactoryService)(new DefaultMetaModelServiceProvider()).getService(metaModelDescriptor, org.artop.aal.gautosar.services.factories.IGAutosarFactoryService.class);
//    }
//
//    protected static final String AUTOSAR_TYPE_NAME = "AUTOSAR";
//    private String initialARPackageName;
}
