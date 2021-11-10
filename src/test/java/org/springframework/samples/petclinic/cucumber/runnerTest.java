package org.springframework.samples.petclinic.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources" })
public class runnerTest extends AbstractTestNGCucumberTests {

}
