package gui;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import model.Order.OrderLine;

public class ReceiptCellRender implements ListCellRenderer<OrderLine> {

    private final DefaultListCellRenderer dcr = new DefaultListCellRenderer();

    @Override
    public Component getListCellRendererComponent(JList<? extends OrderLine> list, OrderLine value, int index, boolean isSelected,
                                                  boolean cellHasFocus) {
        // Get the default renderer component
        Component renderer = dcr.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        // Customize the text to display OrderLine details
        if (value != null) {
            String displayText = "Product: " + value.getProduct() + ", Qty: " + value.getQuantity();
            ((DefaultListCellRenderer) renderer).setText(displayText);
        }

        return renderer;
    }
}
