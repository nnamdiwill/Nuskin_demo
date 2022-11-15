package runPack;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"/Users/nnamdiwilliams/IdeaProjects/Nuskin_demo/src/test/resources/nuskinhp.feature"},
        glue={"stepdefs"},
        publish=true,
        tags="@Nuskin2"
)
public class Runner {


}
