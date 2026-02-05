/*
SOF_U1B2 - Pair Programming Lab (40 minutes)
Topic: Java Generics - Generic Interfaces

Names: Jacob A. S.   Alan

Instructions:
- Complete each .
- Run after each  chunk to test.
- NO bounds yet (no extends/super on type params).
- Keep solutions simple and readable.

Roles (switch halfway)

Driver: types, runs the code, shares keyboard
Navigator: reads instructions, catches mistakes, explains “why”

0–5 min: Assign roles, create file, run it once (expect  failures).
5–20 min: Complete Parts A–C + run tests after each part.
20 min: Switch Driver/Navigator.
20–35 min: Complete Parts D–E.
35–40 min: Clean up: confirm all tests run, add names, push to GitHub.

Each person will turn in a complete copy (make sure ALL work is present).

When finished turn this in on GitHub and Canvas.

This portion is worth 15 points.
*/

public class U1B02Act {
    static void main(String[] args) {

        IO.println("\n=== SOF_U1B2 PAIR LAB: GENERIC INTERFACES ===\n");

        // ============================================================
        // PART A (Warm-up): A generic interface with a default method
        // (Goal: implement Formatter.Formatter<T> + a couple classes)
        // ============================================================


        // - String format(T value);
        // - default void print(T value) { System.out.println(format(value)); }

        // - format(26) -> "0x1A"
        //   hint: Integer.toHexString(value).toUpperCase()

        // - format(x) -> "[" + x + "]"

        // --- Tests for Part A ---

        Formatter<Integer> hex = new IntHexFormatter();
        hex.print(26); // expect 0x1A

        Formatter<String> bracket = new BracketFormatter<>();
        bracket.print("SOF"); // expect [SOF]


        // ============================================================
        // PART B: Generic interface with 2 type parameters
        // (Goal: build Transformer<IN, OUT> + a few implementations)
        // ============================================================

        // - OUT transform(IN input);

        // - "robot" -> 5

        // - constructor takes prefix
        // - transform("x") -> prefix + "x"

        // - 42 -> "42"

        // --- Tests for Part B ---

        Transformer<String, Integer> len = new StringLengthTransformer();
        System.out.println(len.transform("robot")); // expect 5

        Transformer<String, String> vip = new AddPrefixTransformer("VIP-");
        System.out.println(vip.transform("Ada")); // expect VIP-Ada

        Transformer<Integer, String> i2s = new IntToStringTransformer();
        System.out.println(i2s.transform(42)); // expect 42


        // ============================================================
        // PART C: Generic interface as a PARAMETER (no collections)
        // (Goal: write utility methods that accept your generic interfaces)
        // ============================================================


        // - returns transformer.transform(input)
        //
        // Signature hint:
        // static <IN, OUT> OUT applyOnce(IN input, Transformer<IN, OUT> transformer)

        // - applies the transformer twice
        // - This only makes sense when IN and OUT are the same type
        //
        // Signature hint:
        // static <T> T applyTwice(T input, Transformer<T, T> transformer)

        // --- Tests for Part C ---

        Transformer<String, String> tag = new AddPrefixTransformer("#");
        System.out.println(applyOnce("hello", tag));     // expect #hello
        System.out.println(applyTwice("hi", tag));       // expect ##hi

        Transformer<String, Integer> length = new StringLengthTransformer();
        System.out.println(applyOnce("Katherine", length)); // expect 9


        // ============================================================
        // (SWITCH ROLES HERE)
        // ============================================================

        // ============================================================
        // PART D: Another generic interface + implementations (no collections)
        // (Goal: build Rule<T> and test multiple values)
        // ============================================================

        // - boolean test(T value);
        // - default boolean testNot(T value) { return !test(value); }

        // - returns true if the string is not null AND not blank
        //   hint: value != null && !value.isBlank()

        // - returns true if value is not null AND value % 2 == 0

        // - always returns true

        // - returns true only if ALL three values pass the rule
        //
        // Signature hint:
        // static <T> boolean allPass(T a, T b, T c, Rule<T> rule)

        // --- Tests for Part D ---

        Rule<String> nonEmpty = new NonEmptyStringRule();
        System.out.println(allPass("Ada", "Grace", "Katherine", nonEmpty)); // expect true
        System.out.println(allPass("Ada", "   ", "Katherine", nonEmpty));   // expect false

        Rule<Integer> even = new EvenIntegerRule();
        System.out.println(allPass(2, 4, 6, even)); // expect true
        System.out.println(allPass(2, 3, 6, even)); // expect false

        Rule<Double> always = new AlwaysTrueRule<>();
        System.out.println(allPass(1.0, 2.5, 999.9, always)); // expect true

        // ============================================================
        // PART E (Mini-Challenge): Compose generic interfaces
        // (Goal: build ComposedTransformer<IN, MID, OUT>)
        // ============================================================

        // that implements Transformer<IN, OUT>
        //
        // It should have:
        // - private final Transformer<IN, MID> first;
        // - private final Transformer<MID, OUT> second;
        //
        // Constructor:
        // - takes (first, second)
        //
        // transform(input):
        // - MID mid = first.transform(input);
        // - return second.transform(mid);

        // --- Tests for Part E ---

        Transformer<String, String> vip1 = new AddPrefixTransformer("VIP-");
        Transformer<String, Integer> len1 = new StringLengthTransformer();

        Transformer<String, Integer> vipThenLen = new ComposedTransformer<>(vip1, len1);
        System.out.println(vipThenLen.transform("Ada")); // "VIP-Ada" length is 7 -> expect 7

        Transformer<Integer, String> i2s1 = new IntToStringTransformer();
        Transformer<String, String> hash = new AddPrefixTransformer("#");

        Transformer<Integer, String> intThenHash = new ComposedTransformer<>(i2s1, hash);
        System.out.println(intThenHash.transform(42)); // expect #42


        IO.println("\n=== DONE (when everything above is passing) ===\n");
    }

    static <IN, OUT> OUT applyOnce(IN input, Transformer<IN, OUT> transformer) {
        return transformer.transform(input);
    }

    static <T> T applyTwice(T input, Transformer<T, T> transformer) {
        return transformer.transform(input);
    }

    static <T> boolean allPass(T a, T b, T c, Rule<T> rule) {
        return rule.test(a) && rule.test(b) && rule.test(c);
    }
}
