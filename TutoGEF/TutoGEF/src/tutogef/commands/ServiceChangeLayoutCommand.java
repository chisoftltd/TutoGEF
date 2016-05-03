package tutogef.commands;

import org.eclipse.draw2d.geometry.Rectangle;

import tutogef.model.Service;

public class ServiceChangeLayoutCommand extends AbstractLayoutCommand {

	private Service model;
	private Rectangle layout;
	private Rectangle oldLayout;

	public void execute() {
		model.setLayout(layout);
	}

	public void setConstraint(Rectangle rect) {
		this.layout = rect;
	}

	public void setModel(Object model) {
		this.model = (Service) model;
		this.oldLayout = ((Service) model).getLayout();
	}

	// Méthode hérité appelé lors de l'action undo.
	public void undo() {
		this.model.setLayout(this.oldLayout);
	}
}
