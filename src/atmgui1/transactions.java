package atmgui1;
public class transactions {
    public String type;
    public double quantity;
    public transactions(String type, double quantity){
        this.type = type;
        this.quantity = quantity;
    }

    
    public String getType()
    {return type;
    
    }
    public void setType(String type)
    {
    this.type = type;
    }
    public double getQuantity()
    {return quantity;
    
    }
    public void setType(double quantity)
    {
    this.quantity = quantity;
    }
}
