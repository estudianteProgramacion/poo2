package uiProp;

import java.awt.Color;

import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;

@SuppressWarnings("serial")
public class LabelH1 extends Label {

	public LabelH1(Panel container, Color color) {
		super(container);
		this.setFontSize(15).setForeground(color);
	}

}
