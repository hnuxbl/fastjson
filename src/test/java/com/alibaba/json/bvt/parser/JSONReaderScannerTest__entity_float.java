package com.alibaba.json.bvt.parser;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONReaderScanner;

public class JSONReaderScannerTest__entity_float extends TestCase {

    public void test_scanFloat() throws Exception {
        StringBuffer buf = new StringBuffer();
        buf.append('[');
        for (int i = 0; i < 1024; ++i) {
            if (i != 0) {
                buf.append(',');
            }
            buf.append("{\"id\":" + i + ".0}");
        }
        buf.append(']');

        Reader reader = new StringReader(buf.toString());

        JSONReaderScanner scanner = new JSONReaderScanner(reader);

        DefaultJSONParser parser = new DefaultJSONParser(scanner);
        List<VO> array = parser.parseArray(VO.class);
        for (int i = 0; i < array.size(); ++i) {
            Assert.assertEquals((float) i, array.get(i).getId());
        }
    }

    public static class VO {

        private float id;

        public float getId() {
            return id;
        }

        public void setId(float id) {
            this.id = id;
        }

    }
}