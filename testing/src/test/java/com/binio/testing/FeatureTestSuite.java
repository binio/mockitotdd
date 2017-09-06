package com.binio.testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by tomasz.biniecki on 06/09/2017.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArrayCompareTest.class,
        StringHelperTest.class,
        StringHelperParametrizedTest.class
})
public class FeatureTestSuite {
}
