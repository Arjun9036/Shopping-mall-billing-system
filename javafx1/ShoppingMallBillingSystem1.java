import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ShoppingMallBillingSystem1 extends JFrame {
    private JComboBox<String> itemDropdown;
    private JTextField quantityField;
    private JButton addButton;
    private JTextArea billTextArea;
    private JButton calculateButton;
    private JLabel totalLabel;
    private JButton printBillButton;
    private List<Item> cartItems;

    public ShoppingMallBillingSystem1() {
        setTitle("Shopping Mall Billing System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel itemLabel = new JLabel("Item:");
        itemLabel.setBounds(20, 20, 80, 25);
        add(itemLabel);

        String[] items = {"Shirt", "Pants","Dress", "Shoes","Socks","Men's Watches","Mens's Wallet","Men's Kurta","Men's Jacket","Men's FormalShoes",
            "Women's Night suit","Women's suit","Women's Skirt","Women Sandals","Sunglasses","Sportswear","Tea","Coffee","Health Drinks","Kids Toys",
            "Soft Toys","Skin care","Makeup"};
        itemDropdown = new JComboBox<>(items);
        itemDropdown.setBounds(100, 20, 160, 25);
        add(itemDropdown);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(20, 50, 80, 25);
        add(quantityLabel);

        quantityField = new JTextField();
        quantityField.setBounds(100, 50, 160, 25);
        add(quantityField);

        addButton = new JButton("Add to Cart");
        addButton.setBounds(100, 90, 120, 25);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToCart();
            }
        });
        add(addButton);

        billTextArea = new JTextArea();
        billTextArea.setBounds(20, 130, 360, 180);
        add(billTextArea);

        calculateButton = new JButton("Calculate Total");
        calculateButton.setBounds(100, 320, 140, 25);
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotal();
            }
        });
        add(calculateButton);

        totalLabel = new JLabel();
        totalLabel.setBounds(20, 360, 200, 25);
        add(totalLabel);

        printBillButton = new JButton("Print Bill");
        printBillButton.setBounds(250, 320, 120, 25);
        printBillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printBill();
            }
        });
        add(printBillButton);

        cartItems = new ArrayList<>();

        setVisible(true);
    }

    private void addItemToCart() {
        String selectedItem = (String) itemDropdown.getSelectedItem();
        int quantity = Integer.parseInt(quantityField.getText());

        Item item = new Item(selectedItem, quantity);
        cartItems.add(item);

        updateBillTextArea();
    }

    private void updateBillTextArea() {
        billTextArea.setText("");
        for (Item item : cartItems) {
            billTextArea.append("Item: " + item.getName() + "\tQuantity: " + item.getQuantity() + "\n");
        }
    }

    private void calculateTotal() {
        double total = 0;
        for (Item item : cartItems) {
            total += item.calculatePrice();
        }
        totalLabel.setText("Total: $" + total);
    }

    private void printBill() {
        StringBuilder bill = new StringBuilder();
        bill.append("************ Shopping Mall Bill ************\n");
        for (Item item : cartItems) {
            bill.append("Item: ").append(item.getName()).append("\tQuantity: ").append(item.getQuantity()).append("\n");
        }
        double total = 0;
        for (Item item : cartItems) {
            double itemTotal = item.calculatePrice();
            bill.append("Total for ").append(item.getName()).append(": $").append(itemTotal).append("\n");
            total += itemTotal;
        }
        bill.append("************ Total: $").append(total).append(" ************");
        System.out.println(bill.toString());
    }

    private class Item {
        private String name;
        private int quantity;
        private double price;

        public Item(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
            this.price = getPrice();
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            // Pricing logic goes here
            // You can modify this method to set prices for different items
            if (name.equals("Shirt")) {
                return 25.99;
            } else if (name.equals("Pants")) {
                return 39.99;
            } else if (name.equals("Dress")) {
                return 49.99;
            } else if (name.equals("Shoes")) {
                return 59.99;
            }else if (name.equals("Socks")) {
                return 9.99;
            }else if (name.equals("Men's Watches")) {
                return 89.99;
            }else if (name.equals("Men's Wallet")) {
                return 39.99;
            }else if (name.equals("Men's Kurta")) {
                return 29.99;
            }else if (name.equals("Men's Jacket")) {
                return 49.99;
            }else if (name.equals("Men's FormalShoes")) {
                return 69.99;
            }else if (name.equals("Women's Night suit")) {
                return 23.99;
            }else if (name.equals("Women's Skirt")) {
                return 48.99;
            }else if (name.equals("Women's Sandals")) {
                return 30.99;
            }else if (name.equals("Sunglasses")) {
                return 20.99;
            }else if (name.equals("Sportswear")) {
                return 50.99;
            }else if (name.equals("Tea")) {
                return 9.99;
            }else if (name.equals("Coffee")) {
                return 8.99;
            }else if (name.equals("Health Drinks")) {
                return 11.99;
            }else if (name.equals("Kids Toys")) {
                return 17.99;
            }else if (name.equals("Soft Toys")) {
                return 21.99;
            }else if (name.equals("Skin care")) {
                return 31.99;
            }else if (name.equals("Makeup")) {
                return 11.99;
            }
             else {
                return 0;
            }
        }

        public double calculatePrice() {
            return price * quantity;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ShoppingMallBillingSystem1();
            }
        });
    }
}
