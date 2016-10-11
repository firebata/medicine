<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<#import "../../ftl/select.ftl" as sl/>

<@sl.genSelect id="address" datas=["黑龙江","哈尔滨","道里区"]/>

<@sl.genSelect id="sex" datas=["选择性别","男","女"] defaultValue="男"/>

<@sl.genSelect id="sex" datas={"1":"男", "0":"女"} defaultValue="0"/>

<@sl.genSelect id="user" datas=userList key="id" text="name"/>

<@sl.genSelect id="user" datas=userList key="id" text="name" defaultValue="22"/>

<@sl.genSelect id="user" datas=userList key="id" text="name" headKey="-1" headText="选择用户"/>

<@sl.genSelect id="stu" datas=stuList key="stuNo" text="stuName" headKey="-1" headText="选择学生"/>