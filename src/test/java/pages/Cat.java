package pages;

public class Cat extends Pet{

    // Constructor is also related to static polymorphism (same method, different arguments)
    public Cat(){
        name = "nameless one";
    }

    // Constructor is also related to static polymorphism (same method, different arguments)
    public Cat(String value){
        name = value;
    }

    public void speak(){
        System.out.println(name + " is meowing!");
    }

}
