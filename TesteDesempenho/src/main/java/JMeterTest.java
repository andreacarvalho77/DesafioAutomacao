import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

public class JMeterTest {
    public static void main(String[] args) throws Exception {
        // Configurar JMeter
        JMeterUtils.loadJMeterProperties("C:/Program Files/apache-jmeter-5.6.3/bin/jmeter.properties");
        JMeterUtils.setJMeterHome("C:/Program Files/apache-jmeter-5.6.3/bin/jmeter");
        JMeterUtils.initLocale();

        // Inicializar o motor JMeter
        StandardJMeterEngine jmeter = new StandardJMeterEngine();

        // Criar plano de teste
        TestPlan testPlan = new TestPlan("Reqres API Test");

        // Configurar HTTP Request
        HTTPSamplerProxy httpSampler = new HTTPSamplerProxy();
        httpSampler.setDomain("reqres.in");
        httpSampler.setPath("/api/users?page=2");
        httpSampler.setMethod("GET");
        httpSampler.setName("GET Users");

        // Configurar Loop Controller
        LoopController loopController = new LoopController();
        loopController.setLoops(1);
        loopController.addTestElement(httpSampler);
        loopController.setFirst(true);
        loopController.initialize();

        // Configurar Thread Group
        ThreadGroup threadGroup = new ThreadGroup();
        threadGroup.setNumThreads(100);
        threadGroup.setRampUp(10);
        threadGroup.setSamplerController(loopController);

        // Criar árvore de teste
        HashTree testPlanTree = new HashTree();
        HashTree threadGroupTree = testPlanTree.add(testPlan);
        threadGroupTree.add(threadGroup);

        // Configurar ResultCollector com Summariser
        Summariser summariser = new Summariser("Summary");
        String logFile = "result.jtl";
        ResultCollector resultCollector = new ResultCollector(summariser);
        resultCollector.setFilename(logFile);
        testPlanTree.add(resultCollector);

        // Configurar e executar o motor JMeter
        jmeter.configure(testPlanTree);
        jmeter.run();
    }
}
