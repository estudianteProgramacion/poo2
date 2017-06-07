package uiProp;

import java.awt.Color;

import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;

@SuppressWarnings("serial")

public class LabelH3 extends Label {

	public LabelH3(Panel container, Color color) {
		super(container);
		this.setFontSize(12).setForeground(color);
	}

}
