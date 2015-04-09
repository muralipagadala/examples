package com.murali.functional.simple.sam;

public class MethodReference {
    public static String toUpperStatic(String input) {
        return input.toUpperCase();
    }

    public String toUpperInstance(String input) {
        return input.toUpperCase();
    }

    public String toUpperFromThis(String input) {
        MethodReferenceSAM sam = this::toUpperInstance;
        return sam.process(input);
    }
    
    public static void main(String...args){
        MethodReferenceSAM sam = MethodReference::toUpperStatic;
        System.out.println("\n\n\tStatic method reference = "+sam.process("static_input"));
        
        MethodReference methodReference = new MethodReference();
        sam = methodReference::toUpperFromThis;
        System.out.println("\n\n\tInstance method reference = "+sam.process("instance_input"));
        
        System.out.println("\n\n\t\"this\" method reference = "+methodReference.toUpperFromThis("this_input"));
        System.out.println("");
    }
}
