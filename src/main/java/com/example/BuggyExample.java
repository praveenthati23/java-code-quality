package com.example;

import java.util.Objects;

public class BuggyExample {
public static int myStaticVar=42;  // ❌ Checkstyle: poor formatting

private String name;
private int unusedVariable = 10;   // ❌ PMD: unused field

public BuggyExample(String name) {
    this.name = name;
}

/** ❌ Checkstyle: missing Javadoc for public method */
public void doSomething( ) {
System.out.println("Doing something...");   // ❌ Checkstyle: indentation
String localVar = null;
System.out.println(localVar.toString());   // ❌ SpotBugs: possible NullPointerException
}

@Override
public boolean equals(Object o) {
    // ❌ SpotBugs: bad equals implementation (missing instanceof/type check)
    BuggyExample other = (BuggyExample) o;
    return Objects.equals(this.name, other.name);
}

@Override
public int hashCode() {
    return 42;  // ❌ PMD: constant hashCode
}

private void emptyCatch() {    // ❌ PMD: empty catch block
    try {
        int x = 1 / 0;
    } catch (Exception e) {
    }
}
}
