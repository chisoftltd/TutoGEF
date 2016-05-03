package tutogef.part;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import tutogef.AppRenamePolicy;
import tutogef.figure.EmployeFigure;
import tutogef.model.Employe;
import tutogef.model.Node;

public class EmployePart extends AppAbstractEditPart {
	@Override
	protected IFigure createFigure() {
		IFigure figure = new EmployeFigure();
		return figure;
	}

	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub
		installEditPolicy(EditPolicy.NODE_ROLE, new AppRenamePolicy());
	}

	protected void refreshVisuals() {
		EmployeFigure figure = (EmployeFigure) getFigure();
		Employe model = (Employe) getModel();
		figure.setName(model.getName());
		figure.setFirstName(model.getPrenom());
		figure.setLayout(model.getLayout());
	}

	public List<Node> getModelChildren() {
		return new ArrayList<Node>();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(Node.PROPERTY_LAYOUT))
			refreshVisuals();
		if (evt.getPropertyName().equals(Node.PROPERTY_RENAME)) refreshVisuals();
		if (evt.getPropertyName().equals(Employe.PROPERTY_FIRSTNAME)) refreshVisuals();
	}
}
