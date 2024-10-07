//intermediate operations and terminal
//  In Java Streams, operations are divided into two main categories:
//intermediate operations and terminal operations. Understanding the difference between these two is crucial for effectively using the Stream API.
//
//  Intermediate Operations:
//  Intermediate operations are those that transform a stream into another stream. They are lazy, meaning they do not process the elements until a terminal operation is invoked.
//  Intermediate operations are chained together to form a pipeline of operations.
//  Some common intermediate operations include:
//            •	filter(Predicate<? super T> predicate): Filters elements based on a condition.
//            •	map(Function<? super T, ? extends R> mapper): Transforms each element into another form.
//            •	flatMap(Function<? super T, ? extends Stream<? extends R>> mapper): Flattens nested streams into a single stream.
//            •	sorted(Comparator<? super T> comparator): Sorts the elements of the stream.
//            •	distinct(): Removes duplicate elements.
//   Example:
//   
//    List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Alice");
//
//    List<String> distinctSortedNames = names.stream()
//            .distinct()
//            .sorted()
//            .collect(Collectors.toList());
//
//            System.out.println(distinctSortedNames); // Output: [Alice, Bob, Charlie, David]
//
//    Terminal Operations
//    Terminal operations are those that produce a result and terminate the stream pipeline. Once a terminal operation is invoked, the stream is considered consumed and cannot be used further.
//    Some common terminal operations include:
//            •	collect(Collector<? super T, A, R> collector): Collects the elements into a collection (like a list, set, or map).
//            •	for Each(Consumer<? super T> action): Performs an action for each element.
//            •	reduce(BinaryOperator<T> accumulator): Reduces the elements to a single value.
//            •	count(): Returns the number of elements in the stream.
//            •	anyMatch(Predicate<? super T> predicate): Returns true if any elements match the given predicate.
//    Example:
//    
//    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//
//    long count = numbers.stream()
//            .filter(n -> n % 2 == 0)
//            .count();
//
//            System.out.println(count); // Output: 5
//   In this example, filter is an intermediate operation that filters out even numbers, 
//    and count is a terminal operation that counts the filtered elements.

//
//
//    what is predicate and function into the stream api?
//    In the Java Stream API, Predicate and Function are functional interfaces.
//    Predicate:--
//    A Predicate is a functional interface that represents a boolean-valued function. It takes a single argument and returns a boolean value. 
      Predicates are often used in filtering operations.
//
//    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//
//    List<Integer> evenNumbers = numbers.stream()
//            .filter(n -> n % 2 == 0) // Predicate to filter even numbers
//            .collect(Collectors.toList());
//
//             System.out.println(evenNumbers); // Output: [2, 4, 6, 8, 10]
//    Function ::-
//    A Function is a functional interface that represents a function that takes one argument and produces a result.
//    It is often used in mapping operations.
//
//    List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
//
//    List<Integer> nameLengths = names.stream()
//            .map(name -> name.length()) // Function to map names to their lengths
//            .collect(Collectors.toList());
//
//             System.out.println(nameLengths); // Output: [5, 3, 7]
//
//    In this example, name -> name.length() is a Function that maps a name to its length.
//
//
//
//    3. what is consumer and supplier into the stream api?
        
//    Great question! Both Consumer and Supplier are functional interfaces in Java that are commonly used in the Stream API. They serve different purposes:
//    Consumer::---
//    A Consumer represents an operation that takes a single input argument and returns no result. 
      It is typically used for operations that perform some action on an input, such as printing or modifying elements.
//    Example:
//    List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
//
//    names.forEach(name -> System.out.println(name)); // Using Consumer to print each name
//
//    In this example, name -> System.out.println(name) is a Consumer that prints each name.
//
//    Supplier::::---
//    A Supplier represents a function that supplies a result of a specified type. It does not take any arguments.
      Suppliers are often used in scenarios where values are generated or provided on demand.
//    Example:
//    Supplier<Double> randomValue = () -> Math.random();
//
//    System.out.println(randomValue.get()); // Generates a random value
//
//    In this example
//    () -> Math.random() is a Supplier that generates a random double value.
//    Key Differences
//    •	Consumer: Takes one argument and performs an action without returning a result.
//    •	Supplier: Takes no arguments and returns a result.
//
//
//    Consumer Example in Stream API:
//    Java
//    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//
//    numbers.stream()
//        .forEach(n -> System.out.println(n)); // Using Consumer to print each number
//
//    Supplier Example in Stream API:
//    
//    Stream<Double> randomNumbers = Stream.generate(() -> Math.random()).limit(5);
//
//    randomNumbers.forEach(System.out::println); // Using Supplier to generate random numbers
//
//
