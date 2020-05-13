package pages;

public abstract class Animals {

    protected String type;

    public Animals(){
        type = "typeless one";
    }


    public void setType(String value){
        type = value;
    }

    public String getType(){
        return type;
    }

    // methods
    public void walk(){
        System.out.println(type + " is walking");
    }

    public void eat(String what){
        System.out.println(type + " is eating " + what);
    }

    abstract public void speak();

}
