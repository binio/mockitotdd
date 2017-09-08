package com.binio.testing;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;


import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by tomasz.biniecki on 08/09/2017.
 */
public class HamcrestMatchersTest {

    @Test
    public void test() {
        List<Integer> scores = Arrays.asList(1,3,4,6,7,8);
        //sore has 6 items
        assertThat(scores, hasSize(6));

        //score has 6,7,1
        assertThat(scores, hasItems(6,7,1));

        //all elements of score are greater then 0
        assertThat(scores,everyItem(greaterThan(0)));
        assertThat(scores,everyItem(lessThan(10)));

        //String
        assertThat("", isEmptyString());

        //Arrays
        Integer[] marks = {1,2,3,4};
        assertThat(marks, arrayWithSize(4));
        assertThat(marks, arrayContainingInAnyOrder(4,2,3,1));
        assertThat(marks, arrayContaining(1,2,3,4));
    }
}
