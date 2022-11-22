# Fizz Buzz - Live Coding
You can write a Fizz Buzz program, can you test it ?

## Fizz Buzz
The "Fizz Buzz" is a famous interview question designed to filter out candidates who can't seem to program basic rules
[(see C2's wiki)](https://wiki.c2.com/?FizzBuzzTest). It's originally based on a math game in primary school.

Here's the assignment:
- Write a program that prints one line for each number from 1 to 100. But,
- for multiples of three print Fizz instead of the number,
- for multiples of five print Buzz instead of the number,
- for numbers which are multiples of both three and five print FizzBuzz instead of the number.

There's also a more complex variant called [FooBarQix](https://codingdojo.org/kata/FooBarQix/).

## Testing Fizz Buzz
### Closed-box approach
Closed-box approach, or [black-box testing](https://en.wikipedia.org/wiki/Black-box_testing), is a method of software 
testing that examines the functionality of an application without peering into its internal structures or workings.

Since our "box" is closed, we are only aware that a particular input returns a certain, invariable output. Test cases 
are built around specifications and requirements, without any knowledge of the "how".

Think of decision table, state transition, use case, user story.

### Open-box approach
Open-box approach, or [white-box testing](https://en.wikipedia.org/wiki/White-box_testing), is a method of software 
testing that tests internal structures or workings of an application, as opposed to its functionality 
(black box testing). An internal perspective of the system is used to design test cases.

With the knowledge of the "how", test cases can give a specific input to exercise paths through the code and determine 
the expected outputs. We can test paths at the unit, integration and system levels.

Think of control flow, data flow, branch testing.

## Testing tools
### Unit testing with JUnit
[JUnit 5](https://junit.org/junit5/) = JUnit Platform + JUnit Jupiter + JUnit Vintage.

- JUnit Platform is the foundation for launching testing frameworks on the JVM.
- JUnit Jupiter is the combination of a programming model and an extension model for writing tests and extensions in 
- JUnit 5.
- JUnit Vintage provides a test engine for legacy tests.

See also [TestNG](https://testng.org/doc/index.html), etc.

### Property-Based Testing with jqwik
[jqwik](https://jqwik.net) enables [Property-Based Testing](https://jqwik.net/property-based-testing.html) (PBT) to the 
JVM. Jqwik can work with or without the JUnit engine (Jupiter/Vintage) and with your favorite assertion library.

```java
import net.jqwik.api.*;
import org.assertj.core.api.*;

class PropertyBasedTests {

	@Property
	boolean absoluteValueOfAllNumbersIsPositive(@ForAll int anInteger) {
		return Math.abs(anInteger) >= 0;
	}

	@Property
	void lengthOfConcatenatedStringIsGreaterThanLengthOfEach(
		@ForAll String string1, @ForAll String string2
	) {
		String conc = string1 + string2;
		Assertions.assertThat(conc.length()).isGreaterThan(string1.length());
		Assertions.assertThat(conc.length()).isGreaterThan(string2.length());
	}
}
```

See also [JUnit QuickCheck](https://github.com/pholser/junit-quickcheck), 
[Vavr Test](https://github.com/vavr-io/vavr-test), [Scala Check](http://www.scalacheck.org/), etc.

### Test doubles with Mockito
[Mockito](https://site.mockito.org/) enables [mock](https://en.wikipedia.org/wiki/Mock_object) creation, verification 
and stubbing. Mock objects are simulated objects that mimic the behavior of real objects in controlled ways.

Mock example:
```java
import static org.mockito.Mockito.*;

// mock creation
List mockedList = mock(List.class);

// using mock object - it does not throw any "unexpected interaction" exception
mockedList.add("one");
mockedList.clear();

// selective, explicit, highly readable verification
verify(mockedList).add("one");
verify(mockedList).clear();
```

Stubbing example:
```java
// you can mock concrete classes, not only interfaces
LinkedList mockedList = mock(LinkedList.class);

// stubbing appears before the actual execution
when(mockedList.get(0)).thenReturn("first");

// the following prints "first"
System.out.println(mockedList.get(0));

// the following prints "null" because get(999) was not stubbed
System.out.println(mockedList.get(999));
```

See also [BDDMockito](https://www.baeldung.com/bdd-mockito), [JMockit](https://jmockit.github.io/), 
[EasyMock](https://easymock.org/), etc.
