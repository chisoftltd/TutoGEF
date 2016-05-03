package tutogef;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.swt.widgets.Display;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	private static final String PERSPECTIVE_ID = "TutoGEF.perspective"; //$NON-NLS-1$

	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(
			IWorkbenchWindowConfigurer configurer) {
		return new ApplicationWorkbenchWindowAdvisor(configurer);
	}

	public String getInitialWindowPerspectiveId() {
		return PERSPECTIVE_ID;
	}

	@Override
	public void postStartup() {
		
		 Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					IWorkbenchPage page = PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getActivePage();
					page.openEditor(new MyEditorInput("TutoGEF"), MyGraphicalEditor.ID,
							false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}});
		
	}
}
