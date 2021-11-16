package com.lambdaschool.sampleemps.exceptions;

public class ResourceNotFoundException
    extends RuntimeException
{
    public ResourceNotFoundException(String message)
    {
        super("Error from a BloomTech Application " + message);
    }
}
