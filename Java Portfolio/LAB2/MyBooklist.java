public class MyBookList {
    public static void main(String[] args) {
        // 1.) Create the following books that contains the title, author, year published. Use the Book class for this part.
        // Rich Dad Poor Dad, Robert Kiyosaki, 1997
        // The Power of Habit, Charles Duhigg, 2012
        // Atomic Habits, James Clear, 2018
        // Java Programming, John Doe, 2020
        // Add your own favorite book
        Book b1 = new Book("Rich Dad Poor Dad", "Robert Kiyosaki", 1997);
        Book b2 = new Book("The Power of Habit", "Charles Duhigg", 2012);
        Book b3 = new Book("Atomic Habits", "James Clear", 2018);
        Book b4 = new Book("Java Programming", "John Doe", 2020);
        Book b5 = new Book("El Filibusterismo", "José Rizal", 1891);
 
        
        // 2.) Display the details of each book using the displayDetails method. Below is the sample output
        // Title: Rich Dad Poor Dad, Author: Robert Kiyosaki, Year: 1997, Current Page: 0
        // Title: The Power of Habit, Author: Charles Duhigg, Year: 2012, Current Page: 0
        // Title: Atomic Habits, Author: James Clear, Year: 2018, Current Page: 0
        // Title: Java Programming, Author: John Doe, Year: 2020, Current Page: 0
        System.out.println(" ********LIST OF BOOKS********");
        b1.displayDetails();
        b2.displayDetails();
        b3.displayDetails();
        b4.displayDetails();
        b5.displayDetails();
        System.out.println("\n***************************");


        // 3.) Change the current page of "Rich Dad Poor Dad" to 50 and "Atomic Habits" to 100 using the changePage method. Display the details again for the two books.
        b1.changePage(50);
        b3.changePage(100);
        b1.displayDetails();
        b3.displayDetails();
        System.out.println("\n***************************");


        // 4.) Change the current page of your favorite book to any page number you like. Display the details again for your favorite book.
        b5.changePage(368);
        b5.displayDetails();
        System.out.println("\n***************************");


        // 5.) Change the author of "Java Programming" to "Jane Smith". Display the details again for the book.
        b4.setAuthor("Jane Smith");
        b4.displayDetails();


        // 6.) Create an array of Book objects to store all the books you created. Loop through the array and display the title of the books published after 2010.
        Book[] books = {b1, b2, b3, b4, b5};
        System.out.println("\n********BOOKS PUBLISHED AFTER 2010:********");
        for (Book b : books) {
            if (b.getYearPublished() > 2010) {
                System.out.println(b.getTitle());
            }
        }
    }
}
