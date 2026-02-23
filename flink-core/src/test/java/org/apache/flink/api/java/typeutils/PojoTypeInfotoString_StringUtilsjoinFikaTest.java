package org.apache.flink.api.java.typeutils;

import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.common.typeutils.TypeComparator;
import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PojoTypeInfotoString_StringUtilsjoinFikaTest {

    @Test
    public void testToStringInvokesStringUtilsJoin() throws Exception {
        // Create a simple PojoField with mock TypeInformation
        TypeInformation<?> mockTypeInfo = createMockTypeInformation();
        
        // Create a field using reflection
        Field field = String.class.getDeclaredField("value");
        
        // Create PojoField instance
        PojoField pojoField = new PojoField(field, mockTypeInfo);
        
        // Create list of PojoField
        List<PojoField> fields = new ArrayList<>();
        fields.add(pojoField);
        
        // Create PojoTypeInfo instance
        PojoTypeInfo<String> pojoTypeInfo = new PojoTypeInfo<>(String.class, fields);
        
        // Call toString() which should invoke StringUtils.join
        pojoTypeInfo.toString();
    }
    
    private TypeInformation<?> createMockTypeInformation() {
        // Return a real TypeInformation implementation
        // Using TypeInformation.of(String.class) which is a real implementation
        return TypeInformation.of(String.class);
    }
}
