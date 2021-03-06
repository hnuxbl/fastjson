package com.alibaba.json.bvt.serializer;

import org.junit.Assert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import junit.framework.TestCase;

public class IgnoreNonFieldGetterTest2 extends TestCase {

    public void test_int() throws Exception {
        VO vo = new VO();
        vo.setId(123);
        
        String text = JSON.toJSONString(vo, SerializerFeature.IgoreNonFieldGetter);
        Assert.assertEquals("{\"id\":123}", text);
        
    }

    private static class VO {

        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getNextId() {
            return id + 1;
        }
    }
}
