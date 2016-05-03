package tutogef.part.tree;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.gef.editparts.*;

import tutogef.model.Node;

public class AppAbstractTreeEditPart extends AbstractTreeEditPart implements
		PropertyChangeListener {
	public void activate() {
		super.activate();
		((Node) getModel()).addPropertyChangeListener(this);
	}

	public void deactivate() {
		((Node) getModel()).removePropertyChangeListener(this);
		super.deactivate();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}

}
