package lab9.ex1;

public class Book extends Item{

    public Book()
    {
        this.type = "Book";
    }

    @Override
    public void use()
    {
        System.out.println("You are reading a book");
    }

}
