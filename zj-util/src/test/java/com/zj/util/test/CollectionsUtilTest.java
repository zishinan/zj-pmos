package com.zj.util.test;

import com.zj.util.collection.CollectionsUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yangxi on 2017/4/17 0017.
 */
public class CollectionsUtilTest {
    @Test
    public void testPrintln() throws Exception {
        List list = new ArrayList(  );
        for (int i = 0; i < 10; i++) {
            list.add( "ssssssssssss"+i );
        }
        CollectionsUtil.printSimpleCollection2Console( list );
    }
}
