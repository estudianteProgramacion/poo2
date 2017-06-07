package uiProp;

import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;

@SuppressWarnings("serial")
public class NumericFieldMonsters extends NumericField {

	public NumericFieldMonsters(Panel container) {
		super(container);
		this.setFontSize(16).setHeight(20).setWidth(20);
		this.setBackground(PropMonsters.color4);
	}

}
