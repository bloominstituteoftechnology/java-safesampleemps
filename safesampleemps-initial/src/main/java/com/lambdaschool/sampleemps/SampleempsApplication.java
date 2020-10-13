package com.lambdaschool.sampleemps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SampleempsApplication
{

    public static void main(String[] args)
    {
        try
        {
            System.out.println(System.getenv("LAMBDA").toUpperCase());
        } catch (Exception e)
        {
            System.out.println("No Such Environment Variable");
        } finally
        {
            SpringApplication.run(SampleempsApplication.class,
                                  args);
        }
    }

}
