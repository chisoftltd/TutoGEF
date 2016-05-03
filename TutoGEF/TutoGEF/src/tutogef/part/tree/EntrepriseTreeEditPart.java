package tutogef.part.tree;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import tutogef.model.*;
import java.util.List;

public class EntrepriseTreeEditPart extends AppAbstractTreeEditPart {
	protected List<Node> getModelChildren() {
		return ((Entreprise) getModel()).getChildrenArray();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(Node.PROPERTY_ADD))
			refreshChildren();
		if (evt.getPropertyName().equals(Node.PROPERTY_REMOVE))
			refreshChildren();
	}
}
