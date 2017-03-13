/**
* example showing how to use inheritance.
*
**/
public class Vehicle
{
    private String model;
    protected int wheels;

    public Vehicle(String model)
    {
        this.model = model;
        wheels = 4;
    }

    public String getModel()
    {
        return model;
    }

    public String toString()
    {
        return("Vehicle : " + model + "/n wheels : " + wheels);
    }

    protected void setWheels(int x)
    {
        wheels = x;
    }

    public int getWheels()
    {
        return wheels;
    }

    public boolean equals(Object obj)
    {
        if !(obj instanceOf Vehicle)
        {
            return false;
        }
        if(obj == this)
        {
            return true;
        }

        Vehicle v = (Vehicle) obj;

        if (model.equals(v.getModel()) && wheels == v.getWheels())
        {
            return true;
        }
        return false;
    }
}

class Car extends Vehicle
{
    private String model;
    public Car (String model)
    {
        super(model);
    }

    public void setModel(String model)
    {
        this.model = model;
    }
}

class Bicycle extends Vehicle
{
    Public Bicycle
    {
        super("Generic Bike");
        super.setWheeels(2);
    }
}

Class Trial
{
    public Static void main (String[] args)
    {
        Car a = new Car("Toyota");
        Car b = new Car("Mercedes");
        Car c = new Car("Toyota");
        Bicylce d = new Biclycle();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(c.equals(a));
    }
}
