import javax.swing.JOptionPane;

/*
Cree una clase llamada Factura, que una ferretería podría utilizar para representar una factura para
un artículo vendido en la tienda. Una Factura debe incluir un número de factura, un número de
articulo, la descripción del articulo, la cantidad de artículos de ese tipo que se van a comprar y el
precio por artículo.
Su clase debe tener un constructor que inicialice las variables de instancia. Proporcione los
métodos get y set para cada variable de instancia. Además, proporcione un método llamado
obtenerMontoFactura, que calcule el monto de la factura (es decir, que multiplique la cantidad por
el precio por artículo) y después lo devuelva como un valor double. Si la cantidad no es positiva,
debe establecerse en 0. Si el precio por artículo no es positivo, debe establecerse en 0.0. Escriba
una aplicación de prueba llamada PruebaFactura, que demuestre las capacidades de la clase
Factura. 

*/

public class Factura {
    private String numFactura;
    private static int nextNumber = 1001;
    private String numArticle;
    private String description;
    private int amount = 0;
    private float price;
    private float total;

    public Factura()
    {
        setNumFactura();
        setNumArticle();
        setDescription();
        setAmount();
        setPrice();
        setTotal();
    }

    public void setNumFactura()
    {
        numFactura = String.valueOf(nextNumber);
        nextNumber++;
    }
    public String getNumFactura(){return numFactura;}

    public void setNumArticle(){numArticle = JOptionPane.showInputDialog(null, "Ingrese el número del artículo");}
    public String getNumArticle(){return numArticle;}

    public void setDescription(){description = JOptionPane.showInputDialog(null, "Ingrese la descripción");}
    public String getDescription(){return description;}

    public void setAmount()
    {
        do
        {
            amount = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad"));
        }while(amount <= 0);
    }
    public int getAmount(){return amount;}

    public void setPrice()
    {
        do
        {
            price = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el precio del producto"));
        }while(price <= 0);
    }
    public float getPrice(){return price;}

    public void setTotal(){total = amount * price;}
    public float getTotal(){return total;}

    public void mostrarVenta()
    {
        JOptionPane.showMessageDialog(null, 
        "Número de factura: " + numFactura +
        "\nProducto: " + description +       
        "\nCantidad: " + amount +
        "\nCódigo: " + numArticle +
        "\nPrecio unitario: " + price +
        "\nTotal a pagar: $" + total
        );
    }
}
