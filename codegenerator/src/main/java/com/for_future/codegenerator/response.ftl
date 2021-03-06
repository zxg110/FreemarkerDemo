<#assign toBindType = {"Boolean":"Long", "Byte":"Long", "Short":"Long", "Int":"Long", "Long":"Long", "Float":"Double", "Double":"Double", "String":"String", "ByteArray":"Blob" }/>
<#assign toCursorType = {"Boolean":"Short", "Byte":"Short", "Short":"Short", "Int":"Int", "Long":"Long", "Float":"Float", "Double":"Double", "String":"String", "ByteArray":"Blob" }/>
<#assign complexTypes = ["String", "ByteArray", "Date"]/>
package ${model.javaPackageName};
import java.io.Serializable;

// THIS CODE IS GENERATED BY unknown, DO NOT EDIT

public final class ${model.className} implements Serializable {
<#list model.propertyList as property>
    public ${property.key} ${property.value};
</#list>
<#list model.propertyList as property>
<#if property.key="boolean">

    public void set${property.value?cap_first} (${property.key} ${property.value}) {
        this.${property.value} = ${property.value};
    }

    public ${property.key} is${property.value?cap_first} (${property.key} ${property.value}) {
         return ${property.value};
    }
<#else>

    public void set${property.value?cap_first} (${property.key} ${property.value}) {
         this.${property.value} = ${property.value};
    }

    public ${property.key} get${property.value?cap_first} (${property.key} ${property.value}) {
         return ${property.value};
    }
     </#if>
</#list>

    @Override
    public String toString() {
         return "${model.className}{"+
<#list model.propertyList as property>
<#if property_index == 0>
                 "${property.value}='" + ${property.value} + '\''+
<#else>
                 ",${property.value}='" + ${property.value} + '\''+
</#if>
</#list>
                 '}';
    }

}