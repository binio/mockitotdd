package com.binio.powermock;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by tomasz.biniecki on 08/09/2017.
 */

interface Dependency {
    List<Integer> retrieveAllStats();
}

public class SystemUnderTest {


        private Dependency dependency;

        public int methodUsingAnArrayListConstructor() {
            ArrayList list = new ArrayList();
            return list.size();
        }

        public int methodCallingAStaticMethod() {
            //privateMethodUnderTest calls static method SomeClass.staticMethod
            List<Integer> stats = dependency.retrieveAllStats();
            long sum = 0;
            for (int stat : stats)
                sum += stat;
            return UtilityClass.staticMethod(sum);
        }

        private int privateMethodUnderTest() {
            List<Integer> stats = dependency.retrieveAllStats();
            int sum = 0;
            for (int stat : stats)
                sum += stat;
            return sum;
        }
    }
