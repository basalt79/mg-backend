package com.mg.backend;

import java.util.Objects;

public class Greeting {
    private String name;
    
    // is required by JSON serialization layer
    public Greeting() {}
    
    public Greeting(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Greeting)) {
            return false;
        }
        
        Greeting other = (Greeting) obj;
        
        return Objects.equals(other.name, this.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}
