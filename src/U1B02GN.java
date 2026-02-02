///*
//SOF_U1B2 - Guided Notes (20 min)
//Topic: Java Generics - Generic Interfaces
//
//Student Name: Jacob A. S.   Date: 1/12/26
//
//Instructions:
//- Students: fill in the blanks by writing answers in COMMENTS.
//- Run this file often.
//- Don’t worry about bounds yet (we’ll do that next lesson).
//
//Goal today:
//- Define and use GENERIC INTERFACES
//- Implement generic interfaces in different ways
//- Use generic interfaces as types (variables/parameters/return types)
//*/
//
//void main() {
//
//    IO.println("\n=== SOF_U1B2: GENERIC INTERFACES ===\n");
//
//    // ============================================================
//    // 0) QUICK REVIEW (2 minutes)
//    // ============================================================
//
//    // Fill in:
//    // A "type parameter" is like a parameter for a type (ex: T, E, K, V).
//    // A "type argument" is the real type you plug in (ex: String, Integer).
//    //
//    // Example:
//    // Box<T>  -> T is a type parameter
//    // Box<String> -> String is a type argument
//
//    // Reminder:
//    // You can’t use primitives as type arguments (no List<int>).
//    // Use wrapper types: Integer, Double, Boolean, Character, etc.
//
//    // ============================================================
//    // 1) WHAT IS A GENERIC INTERFACE? (3 minutes)
//    // ============================================================
//
//    // Fill in:
//    // An interface describes a contract (what methods exist),
//    // but not necessarily the implementation (how they work).
//    //
//    // A generic interface is an interface that declares one or more type parameters.
//
//    // Example: a generic interface for "holding" something.
//    Holder<String> nameHolder = new SimpleHolder<>("Ada");
//    IO.println("Holder contains: " + nameHolder.get());
//
//    // ============================================================
//    // 2) DECLARING A GENERIC INTERFACE (5 minutes)
//    // ============================================================
//
//    // Key idea:
//    // interface Something<T> { ... }
//    //
//    // Fill in:
//    // In interface Holder<T>, T is in scope for the whole _________.
//
//    Holder<Integer> scoreHolder = new SimpleHolder<>(99);
//    IO.println("Score is: " + scoreHolder.get());
//
//    // ============================================================
//    // 3) IMPLEMENTING A GENERIC INTERFACE (7 minutes)
//    //    Three common patterns:
//    //    A) Class stays generic: class X<T> implements I<T>
//    //    B) Class chooses a concrete type: class X implements I<String>
//    //    C) Class uses multiple type params: I<K, V>
//    // ============================================================
//
//    // A) Class stays generic
//    Holder<Double> piHolder = new SimpleHolder<>(3.14159);
//    IO.println("Pi is: " + piHolder.get());
//
//    // B) Class chooses a concrete type
//    Labeler labeler = new UppercaseLabeler();
//    IO.println("Labeler result: " + labeler.label("robot"));
//
//    // C) Multiple type parameters
//    Pair<String, Integer> p = new SimplePair<>("level", 5);
//    IO.println("Pair first: " + p.first() + " | second: " + p.second());
//
//    // ============================================================
//    // 4) USING GENERIC INTERFACES AS TYPES (3 minutes)
//    // ============================================================
//
//    // Fill in:
//    // Using an interface type lets you swap implementations without changing the ________ code.
//    //
//    // Example:
//    Printer<String> excitedPrinter = new ExclaimPrinter();
//    excitedPrinter.print("hello");
//
//    Printer<Integer> intPrinter = new BracketPrinter<>();
//    intPrinter.print(42);
//
//    // ============================================================
//    // 5) DEFAULT + STATIC METHODS (OPTIONAL IF TIME) (2 minutes)
//    // ============================================================
//
//    // Default methods: concrete method inside an interface.
//    // Fill in:
//    // A default method lets an interface provide a __________ implementation.
//
//    Printer<String> plain = new PlainPrinter<>();
//    plain.print("default method demo");
//
//    // Static methods in interfaces:
//    // Important detail:
//    // - A static method in an interface does NOT automatically have access to the interface’s type parameter
//    //   unless the static method declares its own <T>.
//    PrinterUtil.printTwice("hi");
//    PrinterUtil.printTwice(7);
//
//    IO.println("\n=== END NOTES ===\n");
//}
//
//
//// ============================================================
//// INTERFACES + IMPLEMENTATIONS USED IN NOTES
//// ============================================================
