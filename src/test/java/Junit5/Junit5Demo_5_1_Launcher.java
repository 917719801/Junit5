package Junit5;
/*
代码API触发
 */

import junitexamples.packageA.ClassATest;
import org.junit.platform.launcher.*;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import static org.junit.platform.engine.discovery.ClassNameFilter.excludeClassNamePatterns;
import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.*;

public class Junit5Demo_5_1_Launcher {
    public static void main(String[] args) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(
                        //指定包执行
                        selectPackage("junitexamples")
                       // selectClass(ClassATest.class)
                        //selectMethod("examples.packageA.ClassATest#testCaseA")

                ).filters(
                        //包含Atest执行
                     //   includeClassNamePatterns(".*ATest")
                        //包含ATest不执行
                        excludeClassNamePatterns(".*ATest")
                ).build();

        Launcher launcher = LauncherFactory.create();

        TestExecutionListener listener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(listener);

        launcher.execute(request);
    }
}
