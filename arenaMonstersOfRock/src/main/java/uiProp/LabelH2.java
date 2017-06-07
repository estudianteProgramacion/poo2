package uiProp;

import java.awt.Color;

import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;

@SuppressWarnings("serial")
public class LabelH2 extends Label {

	public LabelH2(Panel container, Color color) {
		super(container);
		this.setFontSize(14).setForeground(color);
	}

}
