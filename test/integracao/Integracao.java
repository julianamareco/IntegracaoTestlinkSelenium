package integracao;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class Integracao {

    public static final String TESTLINK_KEY = "8305a296244bd063e868bf5a357946d0";
    public static final String TESTLINK_URL = "http://lesse.com.br/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
    public static final String TEST_PROJECT_NAME = "Gerenciador Pampatec";
    public static final String TEST_PLAN_NAME = "Novo plano de teste";
    public static final String TEST_CASE_NAME = "Novo caso de teste";
    public static final String BUILD_NAME = "Versao1";
    
    public static void updateResults(String testCaseName, String exception, String results) throws TestLinkAPIException{
        TestLinkAPIClient testlink = new TestLinkAPIClient(TESTLINK_KEY, TESTLINK_URL);
        testlink.reportTestCaseResult(TEST_PROJECT_NAME, TEST_PLAN_NAME, testCaseName, BUILD_NAME, exception, results);
    }
    
}
