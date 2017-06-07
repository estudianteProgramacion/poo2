package uiProp;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Container;

@SuppressWarnings("serial")
public class ButtonC extends Button {

	public ButtonC(Container container) {
		super(container);
		this.setForeground(PropMonsters.color1).setFontSize(13).setHeight(35);
	}

}
