package pages;

public abstract class Pet {  // pet is 'superclass'

    // fields
    // set private access-modifier, using ENCAPSULATION
    protected String name;


    public Pet(){
        name = "nameless one";
    }


    public void setName(String value){
        name = value;
    }

    public String getName(){
        return name;
    }


    // methods
    public void walk(){
        System.out.println(name + " is walking"); // 'public' means you can call this method outside of this 'pages' package
    }

    public void eat(String what){
        System.out.println(name + " is eating " + what);
    }

    abstract public void speak();

}
