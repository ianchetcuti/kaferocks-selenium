package rocks.kafe.main;

import rocks.kafe.managers.WebManager;

public class KaFeRocksDemo {

    public static void main(String[] args) {
        //As a standalone application testsuite
        WebManager testOrchestrator = new WebManager();

        testOrchestrator.initialiseWebTests();
    }
}
