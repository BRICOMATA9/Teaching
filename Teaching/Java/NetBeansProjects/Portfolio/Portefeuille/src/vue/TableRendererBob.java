package vue;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class TableRendererBob extends DefaultTableCellRenderer
{

	private static final long serialVersionUID = 1L;

	@Override	
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column)
	{
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
				row, column);

		this.setHorizontalAlignment(LEFT);

		return this;
	}
}

