<#--
自定义指令genSelect的参数说明，如下
id           必填。用于指定<select>的id和name属性值
datas        必填。用于指定数据模型，可以是序列、哈希表、java.util.List等
key          选填。用于指定<option>的key和text
text         选填。同key
headKey      选填。用于指定所显示的第一个<option>，其具有提示信息的意义
headText     选填。同headKey
defaultValue 选填。用于指定默认的<option>
-->
<#macro genSelect id datas key="" text="" headKey="" headText="" defaultValue="">
<select id="${id}" name="${id}" class="select_half">
<#-- 判断是否需要显示提示性的<option> -->
    <#if headKey!="">
        <option value="${headKey}">${headText}</option>
    </#if>
<#-- 判断传入的数据模型是否为哈希表 -->
    <#if datas?is_hash_ex>
    <#-- 获取哈希表的key集合 -->
        <#local keys=datas?keys/>
        <#list keys as key>
            <#if key == defaultValue>
                <option value="${key}" selected>${datas[key]}</option>
            <#else>
                <option value="${key}">${datas[key]}</option>
            </#if>
        </#list>
    <#-- 如果传入的数据模型不是哈希表，则可以当作序列或java.util.List来处理 -->
    <#else>
        <#list datas as data>
        <#-- 通常这个判断是针对数据模型为java.util.List的 -->
            <#if key!="">
                <#if defaultValue==data[key]?string>
                    <option value="${data[key]}" selected>${data[text]}</option>
                <#else>
                    <option value="${data[key]}">${data[text]}</option>
                </#if>
            <#-- 通常这个判断是针对数据模型为序列的 -->
            <#else>
                <#if defaultValue==data>
                    <option value="${data}" selected>${data}</option>
                <#else>
                    <option value="${data}">${data}</option>
                </#if>
            </#if>
        </#list>
    </#if>
</select>
</#macro>