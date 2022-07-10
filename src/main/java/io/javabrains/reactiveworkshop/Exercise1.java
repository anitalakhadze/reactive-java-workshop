package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {
        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        System.out.println("Printing all numbers in the intNumbersStream stream");
        StreamSources.intNumbersStream()
                .forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        System.out.println("\nPrinting numbers from intNumbersStream that are less than 5");
        StreamSources.intNumbersStream()
                .filter(number -> number < 5)
                .forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("\nPrinting the second and third numbers in intNumbersStream that's greater than 5");
        StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println("\nPrinting the first number in intNumbersStream that's greater than 5. If nothing is found, print -1");
        Integer value = StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(value);

        // Print first names of all users in userStream
        System.out.println("\nPrinting first names of all users in userStream without map()");
        StreamSources.userStream()
                .forEach(user -> System.out.println(user.getFirstName()));

        System.out.println("\nPrinting first names of all users in userStream with map()");
        StreamSources.userStream()
                .map(user -> user.getFirstName())
                .forEach(System.out::println);

        // Print first names in userStream for users that have IDs from number stream
        System.out.println("\nPrinting first names in userStream for users that have IDs from number stream with anyMatch()");
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream().anyMatch(u -> u.equals(user.getId())))
                .map(user -> user.getFirstName())
                .forEach(System.out::println);

        System.out.println("\nPrinting first names in userStream for users that have IDs from number stream with flatMap()");
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .map(user -> user.getFirstName())
                .forEach(System.out::println);
    }

}
